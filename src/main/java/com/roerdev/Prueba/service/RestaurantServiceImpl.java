package com.roerdev.Prueba.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.roerdev.Prueba.config.Constans;
import com.roerdev.Prueba.config.RappiConfig;
import com.roerdev.Prueba.dto.LocationDto;
import com.roerdev.Prueba.dto.RestauranteDto;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private Logger logger = LoggerFactory.getLogger(RestaurantServiceImpl.class);

    private final RappiConfig rappiConfig;

    public RestaurantServiceImpl(RappiConfig rappiConfig) {
        this.rappiConfig = rappiConfig;
    }


    @Override
    public List<RestauranteDto> getRestaurant(LocationDto locationDto) throws Exception {

        List<RestauranteDto> restauranteDtoList = new ArrayList<>();

        var webPage = Jsoup.connect(rappiConfig.getConsultaRestUrl()).get();
        var data = Objects.requireNonNull(webPage.getElementById("__NEXT_DATA__")).data();
        JsonObject json = new JsonParser().parse(data).getAsJsonObject();
        var props = json.get("props").getAsJsonObject();
        var pageProps = props.get("pageProps").getAsJsonObject();
        var restaurants = pageProps.get("restaurants").getAsJsonObject();
        var stores = restaurants.get("stores").getAsJsonArray();

        stores.forEach(jsonElement -> {
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            String asJsonString = jsonElement.toString();
            RestauranteDto restaurant = gson.fromJson(asJsonString, RestauranteDto.class);
            var distance = Math.round(distanciaCoord(locationDto, new LocationDto(restaurant.getLocation().get(1), restaurant.getLocation().get(0)))*100.0)/100.0;
            restaurant.setDistanceKm(distance+"KM");
            if( distance <= Constans.MINIMAL_DISTANCE_KM) {
                restauranteDtoList.add(restaurant);
            }
        });

        return restauranteDtoList;
    }

    public double distanciaCoord(LocationDto locationCook, LocationDto locationRestaurant) {
        double radioTierra = 6371;
        double dLat = Math.toRadians(Double.parseDouble(locationRestaurant.getLatitude().toString()) - Double.parseDouble(locationCook.getLatitude().toString()));
        double dLng = Math.toRadians(Double.parseDouble(locationRestaurant.getLongitude().toString()) - Double.parseDouble(locationCook.getLongitude().toString()));
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double va1 = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(Double.parseDouble(locationCook.getLatitude().toString()))) * Math.cos(Math.toRadians(Double.parseDouble(locationRestaurant.getLatitude().toString())));
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
        double distancia = radioTierra * va2;
        logger.info("Distancia entre {} y {} es {}", locationCook, locationRestaurant, distancia);
        return distancia;
    }

}

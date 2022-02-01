package com.roerdev.Prueba.service;

import com.roerdev.Prueba.dto.LocationDto;
import com.roerdev.Prueba.dto.RestauranteDto;

import java.util.List;

public interface RestaurantService {

    List<RestauranteDto> getRestaurant(LocationDto locationDto) throws Exception;


}

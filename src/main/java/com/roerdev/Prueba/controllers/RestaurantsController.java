package com.roerdev.Prueba.controllers;

import com.roerdev.Prueba.dto.LocationDto;
import com.roerdev.Prueba.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class RestaurantsController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantsController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping(value = "restaurants")
    public ResponseEntity<?> getRestaurant(@RequestBody LocationDto locationDto) {
        try {
            var restaurant = this.restaurantService.getRestaurant(locationDto);
            return ResponseEntity.ok(restaurant);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.internalServerError().build();
    }

}

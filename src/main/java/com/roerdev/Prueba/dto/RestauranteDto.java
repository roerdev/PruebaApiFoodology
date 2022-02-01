package com.roerdev.Prueba.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestauranteDto {

    private String store_id;
    private Integer index;
    private String name;
    private List<BigDecimal> location;
    private String address;
    private String status;
    private boolean open;
    private String distanceKm;
}

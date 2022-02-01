package com.roerdev.Prueba.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {

    private BigDecimal latitude;
    private BigDecimal longitude;

}

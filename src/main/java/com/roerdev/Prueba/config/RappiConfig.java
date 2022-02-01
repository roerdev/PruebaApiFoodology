package com.roerdev.Prueba.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "restaurantes", ignoreInvalidFields = true)
public class RappiConfig {

    private String consultaRestUrl;
}

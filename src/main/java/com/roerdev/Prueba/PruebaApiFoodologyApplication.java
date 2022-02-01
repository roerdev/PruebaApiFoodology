package com.roerdev.Prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableConfigurationProperties
public class PruebaApiFoodologyApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PruebaApiFoodologyApplication.class, args);
	}

}

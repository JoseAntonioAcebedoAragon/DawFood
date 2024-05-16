package com.dawfood.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DawFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(DawFoodApplication.class, args);
	}

}

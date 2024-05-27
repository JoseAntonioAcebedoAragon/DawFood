package com.dawfood.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan({"com.dawfood.app.repository", "com.dawfood.app.controller", "com.dawfood.app.service"})

public class DawFoodApplication {

	public static void main(String[] args) {SpringApplication.run(DawFoodApplication.class, args);
	}

}
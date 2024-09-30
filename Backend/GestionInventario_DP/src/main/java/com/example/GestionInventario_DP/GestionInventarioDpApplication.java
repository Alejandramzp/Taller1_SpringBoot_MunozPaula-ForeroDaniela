package com.example.GestionInventario_DP;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class GestionInventarioDpApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(GestionInventarioDpApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(GestionInventarioDpApplication.class, args);
	}

}

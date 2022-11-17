package com.aston.travelInsurence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HealthInsurenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthInsurenceApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedHeaders("Access-Control-Allow-Origin",
								"Access-Control-Allow-Headers",
								"content-type")
						.allowedMethods("GET", "PUT", "POST");
			}
		};
	}

}

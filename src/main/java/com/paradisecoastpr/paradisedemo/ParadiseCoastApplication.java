package com.paradisecoastpr.paradisedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ParadiseCoastApplication {
	public static void main(String[] args) {
		SpringApplication.run(ParadiseCoastApplication.class, args);
	}
}

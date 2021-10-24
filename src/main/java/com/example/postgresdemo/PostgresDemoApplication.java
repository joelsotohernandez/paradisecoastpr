package com.example.postgresdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@EnableJpaAuditing
@Transactional
public class PostgresDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(PostgresDemoApplication.class, args);
	}
}

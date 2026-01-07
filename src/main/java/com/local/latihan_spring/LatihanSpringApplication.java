package com.local.latihan_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaAuditing
public class LatihanSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LatihanSpringApplication.class, args);
	}

}

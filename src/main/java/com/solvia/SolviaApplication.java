package com.solvia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SolviaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolviaApplication.class, args);
	}

}

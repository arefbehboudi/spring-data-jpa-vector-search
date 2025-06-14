package com.aref.vector_search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class VectorSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(VectorSearchApplication.class, args);
	}

}

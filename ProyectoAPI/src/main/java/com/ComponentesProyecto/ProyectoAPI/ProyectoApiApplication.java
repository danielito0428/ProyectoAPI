package com.ComponentesProyecto.ProyectoAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ProyectoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoApiApplication.class, args);
	}

}

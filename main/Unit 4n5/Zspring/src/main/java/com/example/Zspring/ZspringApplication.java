package com.example.Zspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZspringApplication implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		// Application startup logic can be added here
	}

	public static void main(String[] args) {
		SpringApplication.run(ZspringApplication.class, args);
	}

}

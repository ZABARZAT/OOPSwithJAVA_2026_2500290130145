package com.example.Zspring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class StudentApplication implements CommandLineRunner {
    static final Logger logger = LoggerFactory.getLogger(StudentApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("KIET Student Management System Started");
        logger.info("Loading Student Data...");
        logger.info("Student Management REST API is ready");
    }
}

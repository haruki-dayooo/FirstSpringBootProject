package com.springdemo.springbootproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootProjectApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringBootProjectApplication.class);
    public static void main(String[] args) {

        SpringApplication.run(SpringBootProjectApplication.class, args);
        log.info("Application started successfully!");
    }

}

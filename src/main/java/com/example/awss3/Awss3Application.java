package com.example.awss3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Awss3Application {

    public static final String APPLICATION_LOCATIONS = "spring.config.location=" +
            "classpath:application.yml," +
            "classpath:aws.yml";

    public static void main(String[] args) {
        new SpringApplicationBuilder(Awss3Application.class)
                .properties(APPLICATION_LOCATIONS)
                .run(args);
    }

}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        LoadDriver();
        SpringApplication.run(DemoApplication.class, args);
    }

    private static void LoadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver").getConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

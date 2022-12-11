package com.example.gestionachat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling

public class GestionAchatApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionAchatApplication.class, args);
    }

}

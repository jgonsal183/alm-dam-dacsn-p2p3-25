package com.ejemplo.notas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;

@SpringBootApplication
public class NotasApplication {
    public static void main(String[] args) {
        new File("db").mkdirs();
        SpringApplication.run(NotasApplication.class, args);
    }
}
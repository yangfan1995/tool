package com.pawn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToolApplication {

    public static void main(String[] args) {
        String rootPath = System.getProperty("user.dir");
        System.setProperty("log.base",rootPath);
        SpringApplication.run(ToolApplication.class, args);
    }

}

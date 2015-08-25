package com.ucm.ilsa.clavinweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class ClavinWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ClavinWebApplication.class, args);
    }
}

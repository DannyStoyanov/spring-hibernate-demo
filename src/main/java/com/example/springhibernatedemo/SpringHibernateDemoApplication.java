package com.example.springhibernatedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class SpringHibernateDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateDemoApplication.class, args);
        try {
            Logger logger = LoggerFactory.getLogger(SpringHibernateDemoApplication.class);
            logger.info("RUNNING!");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}

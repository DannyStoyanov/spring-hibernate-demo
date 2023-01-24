package com.example.springhibernatedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.lang.reflect.*;
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

package com.rodzyn.homework08hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Homework08HibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(Homework08HibernateApplication.class, args);
    }

}

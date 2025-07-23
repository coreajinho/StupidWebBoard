package org.example.stupidboard;

import org.example.stupidboard.controllers.Testcontroller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StupidBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(StupidBoardApplication.class, args);
        Testcontroller test = new Testcontroller();
        test.testmethod();
    }
}


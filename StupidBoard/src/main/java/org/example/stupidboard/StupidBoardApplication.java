package org.example.stupidboard;

import org.example.stupidboard.controllers.Postcontroller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StupidBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(StupidBoardApplication.class, args);
    }
}


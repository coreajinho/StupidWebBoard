package org.example.stupidBoard.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PostNotFoundExeption extends Exception {
    public PostNotFoundExeption(String message){
        super(message);
    }
}

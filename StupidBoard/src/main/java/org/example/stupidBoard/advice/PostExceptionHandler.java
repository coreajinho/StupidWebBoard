package org.example.stupidBoard.advice;

import org.example.stupidBoard.controllers.Postcontroller;
import org.example.stupidBoard.exception.PostNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = {Postcontroller.class})
public class PostExceptionHandler {

    @ExceptionHandler(PostNotFoundExeption.class)
    public ResponseEntity<String> handlePostNotFoundException(PostNotFoundExeption e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }
}

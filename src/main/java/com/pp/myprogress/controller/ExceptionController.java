package com.pp.myprogress.controller;

import com.pp.myprogress.exception.IllegalValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler({IllegalValueException.class})
    public ResponseEntity<String> handle(IllegalValueException ive, WebRequest request){
        return ResponseEntity
                .badRequest()
                .body("Situation under control. Don't panic. Incorrect value: " + ive.getMessage());
    }
}

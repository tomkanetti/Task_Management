package com.tom.microuser.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAppHandler {

    @ExceptionHandler(value = MicroUserException.class)
    public ResponseEntity<Object> exception(MicroUserException exception) {
        return new ResponseEntity<>(exception.getMessage(),exception.getHttpStatus());
    }

}

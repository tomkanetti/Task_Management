package com.tom.microtask.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAppHandler {

    @ExceptionHandler(value = MicroTaskException.class)
    public ResponseEntity<Object> exception(MicroTaskException exception) {
        return new ResponseEntity<>(exception.getMessage(),exception.getHttpStatus());
    }

}

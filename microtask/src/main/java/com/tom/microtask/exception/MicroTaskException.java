package com.tom.microtask.exception;

import org.springframework.http.HttpStatus;

public class MicroTaskException extends Exception {

    HttpStatus httpStatus;
    String message;

    public MicroTaskException(String message, HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }


    @Override
    public String getMessage() {
        return message;
    }

}

package com.tom.microuser.exception;

import org.springframework.http.HttpStatus;

import javax.lang.model.type.ErrorType;

public class MicroUserException extends Exception {

    HttpStatus httpStatus;
    String message;

    public MicroUserException(String message,HttpStatus httpStatus) {
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

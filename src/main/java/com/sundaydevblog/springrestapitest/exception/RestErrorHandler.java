package com.sundaydevblog.springrestapitest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomResponse> handleNotFoundException(Exception ex) {
        CustomResponse error = new CustomResponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomResponse> handleBadRequestException() {
        CustomResponse error = new CustomResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Your request has issued a malformed or illegal request.");

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
package com.sundaydevblog.springrestapitest.exception;

public class CustomResponse {

    private int status;

    private String message;

    public CustomResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
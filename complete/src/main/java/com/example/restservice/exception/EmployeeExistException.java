package com.example.restservice.exception;

public class EmployeeExistException extends RuntimeException{
    private String message;

    public EmployeeExistException() {

    }

    public EmployeeExistException(String message) {
        super(message);
        this.message = message;
    }
}

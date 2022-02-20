package com.example.restservice.exception;

public class EmployeeExistExeption extends RuntimeException{
    private String message;

    public EmployeeExistExeption() {

    }

    public EmployeeExistExeption(String message) {
        super(message);
        this.message = message;
    }
}

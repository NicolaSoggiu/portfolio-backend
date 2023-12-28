package com.example.newportfolio.exception;

public class TechnologyNotFoundException extends RuntimeException{
    public TechnologyNotFoundException(String message) {
        super(message);
    }
}
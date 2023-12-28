package com.example.newportfolio.exception;

public class ProjectNameUniqueException extends RuntimeException{
    public ProjectNameUniqueException(String message) {
        super(message);
    }
}
package com.controlhub.demo.config.exception;

public class FibonacciNotFoundException extends RuntimeException{
    public FibonacciNotFoundException(String message) {
        super(message);
    }
}

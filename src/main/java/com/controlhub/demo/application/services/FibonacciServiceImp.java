package com.controlhub.demo.application.services;

import com.controlhub.demo.application.port.in.FibonacciService;
import com.controlhub.demo.application.port.out.FibonacciRepository;
import com.controlhub.demo.config.exception.FibonacciNotFoundException;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class FibonacciServiceImp implements FibonacciService {
    private final FibonacciRepository fibonacciRepository;
    @Override
    public long calculateFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Index cannot be negative.");
        }
        if (n <= 1) {
            throw new FibonacciNotFoundException("Fibonacci value not found for index " + n);
        }
        return fibonacciRepository.calculateFibonacci(n);
    }
}

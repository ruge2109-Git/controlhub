package com.controlhub.demo.application.services;

import com.controlhub.demo.application.port.in.FibonacciService;
import com.controlhub.demo.application.port.out.FibonacciRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class FibonacciServiceImp implements FibonacciService {
    private final FibonacciRepository fibonacciRepository;
    @Override
    public long calculateFibonacci(int n) {
        return fibonacciRepository.calculateFibonacci(n);
    }
}

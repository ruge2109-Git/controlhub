package com.controlhub.demo.adapters.repository;

import com.controlhub.demo.application.port.out.FibonacciRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MemoryFibonacciRepository implements FibonacciRepository {
    @Override
    public long calculateFibonacci(int n) {
        if (n <= 1) return n;
        long fib1 = 0, fib2 = 1, result = 0;
        for (int i = 2; i <= n; i++) {
            result = fib1 + fib2;
            fib1 = fib2;
            fib2 = result;
        }
        return result;
    }
}

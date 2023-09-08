package com.controlhub.demo.adapters.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MemoryFibonacciRepositoryTest {
    private MemoryFibonacciRepository memoryFibonacciRepository;

    @BeforeEach
    void setUp(){
        memoryFibonacciRepository = new MemoryFibonacciRepository();
    }

    @Test
    void calculateFibonacci_WhenNIsZero_ReturnsZero() {
        int n = 0;
        long expectedResult = 0;

        long result = memoryFibonacciRepository.calculateFibonacci(n);

        assertEquals(expectedResult, result);
    }

    @Test
    void calculateFibonacci_WhenNIsOne_ReturnsOne() {
        int n = 1;
        long expectedResult = 1;

        long result = memoryFibonacciRepository.calculateFibonacci(n);

        assertEquals(expectedResult, result);
    }

    @Test
    void calculateFibonacci_WhenNIsPositive_ReturnsCorrectResult() {
        int n = 5;
        long expectedResult = 5;

        long result = memoryFibonacciRepository.calculateFibonacci(n);

        assertEquals(expectedResult, result);
    }

    @Test
    void calculateFibonacci_WhenNIsLarge_ReturnsCorrectResult() {
        int n = 6;
        long expectedResult = 55;

        long result = memoryFibonacciRepository.calculateFibonacci(n);

        assertEquals(expectedResult, result);
    }
}

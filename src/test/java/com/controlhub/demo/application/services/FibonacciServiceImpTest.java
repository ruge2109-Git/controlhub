package com.controlhub.demo.application.services;

import com.controlhub.demo.application.port.out.FibonacciRepository;
import com.controlhub.demo.config.exception.FibonacciNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FibonacciServiceImpTest {
    private FibonacciServiceImp fibonacciService;

    @Mock
    private FibonacciRepository fibonacciRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        fibonacciService = new FibonacciServiceImp(fibonacciRepository);
    }

    @Test
    void calculateFibonacci_ValidIndex_ReturnsResult() {
        int index = 5;
        long expectedResult = 5;
        Mockito.when(fibonacciRepository.calculateFibonacci(index)).thenReturn(expectedResult);

        long result = fibonacciService.calculateFibonacci(index);

        assertEquals(expectedResult, result);
    }

    @Test
    void calculateFibonacci_NegativeIndex_ThrowsIllegalArgumentException() {
        int negativeIndex = -1;

        assertThrows(IllegalArgumentException.class, () -> fibonacciService.calculateFibonacci(negativeIndex));
    }

    @Test
    void calculateFibonacci_IndexNotFound_ThrowsFibonacciNotFoundException() {
        int index = 0;

        assertThrows(FibonacciNotFoundException.class, () -> fibonacciService.calculateFibonacci(index));
    }
}

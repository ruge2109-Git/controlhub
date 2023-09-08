package com.controlhub.demo.adapters.web;

import com.controlhub.demo.application.port.in.FibonacciService;
import com.controlhub.demo.config.exception.FibonacciNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
public class FibonacciControllerTest {
    private FibonacciController fibonacciController;
    @Mock
    private FibonacciService fibonacciService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        fibonacciController = new FibonacciController(fibonacciService);
    }

    @Test
    void calculateFibonacci_ValidIndex_ReturnsOkResponse() {
        int index = 5;
        long expectedResult = 5;
        when(fibonacciService.calculateFibonacci(index)).thenReturn(expectedResult);

        ResponseEntity<Object> response = fibonacciController.calculateFibonacci(String.valueOf(index));

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResult, response.getBody());
    }

    @Test
    void calculateFibonacci_NegativeIndex_ReturnsNotFoundResponse() {
        int negativeIndex = -1;
        when(fibonacciService.calculateFibonacci(negativeIndex)).thenThrow(IllegalArgumentException.class);

        ResponseEntity<Object> response = fibonacciController.calculateFibonacci(String.valueOf(negativeIndex));

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void calculateFibonacci_IndexNotFound_ReturnsNotFoundResponse() {
        int index = 0;
        when(fibonacciService.calculateFibonacci(index)).thenThrow(FibonacciNotFoundException.class);

        ResponseEntity<Object> response = fibonacciController.calculateFibonacci(String.valueOf(index));

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}

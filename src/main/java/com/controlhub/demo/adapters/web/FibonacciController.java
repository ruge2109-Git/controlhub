package com.controlhub.demo.adapters.web;

import com.controlhub.demo.application.port.in.FibonacciService;
import com.controlhub.demo.config.exception.FibonacciNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fibonacci")
@RequiredArgsConstructor
public class FibonacciController {
    private final FibonacciService fibonacciService;

    @GetMapping("/{index}")
    public ResponseEntity<Object> calculateFibonacci(@PathVariable String index) {
        try {
            long result = fibonacciService.calculateFibonacci(Integer.parseInt(index));
            return ResponseEntity.ok(result);
        } catch (NumberFormatException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid input. Please enter a valid integer.");
        } catch (FibonacciNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }
}

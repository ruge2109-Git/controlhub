package com.controlhub.demo.adapters.web;

import com.controlhub.demo.application.port.in.FibonacciService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fibonacci")
@RequiredArgsConstructor
public class FibonacciController {
    private final FibonacciService fibonacciService;
    @GetMapping("/{n}")
    public long calculateFibonacci(@PathVariable int n) {
        return fibonacciService.calculateFibonacci(n);
    }
}

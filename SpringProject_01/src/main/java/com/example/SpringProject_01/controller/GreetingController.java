package com.example.SpringProject_01.controller;

import com.example.SpringProject_01.Greeting;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
class GreetingController {
    private final Greeting greeting;
    public GreetingController(Greeting greeting) {
        this.greeting = greeting;
    }
    @GetMapping
    String getGreeting() {
        return greeting.getName();
    }
    @GetMapping("/coffee")
    String getNameAndCoffee() {
        return greeting.getCoffee();
    }
}

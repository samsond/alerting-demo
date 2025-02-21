package com.example.alerting_demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RandomErrorController {

    private final Random random = new Random();

    @GetMapping("/api/random-error")
    public ResponseEntity<String> randomError() {
        int chance = random.nextInt(10);
        if (chance < 3) {
            throw new RuntimeException("Random meltdown occurred!");
        }
        return ResponseEntity.ok("All clear (chance = " + chance + ")");
    }
}


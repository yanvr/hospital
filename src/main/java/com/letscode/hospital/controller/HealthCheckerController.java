package com.letscode.hospital.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckerController {

    @GetMapping("/health-check")
    public String check() {
        return "Server is running";
    }
}

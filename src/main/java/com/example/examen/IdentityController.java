package com.example.examen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdentityController {

    @GetMapping("/verify-ci")
    public String verificarCI(@RequestParam String ci) {
        if ("12345678".equals(ci)) {
            return "La CI existe.";
        } else {
            return "La CI no existe.";
        }
    }
}

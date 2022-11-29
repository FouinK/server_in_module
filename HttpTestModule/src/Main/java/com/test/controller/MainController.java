package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MainController {

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        return request.getHeader("Zuul");
    }
}

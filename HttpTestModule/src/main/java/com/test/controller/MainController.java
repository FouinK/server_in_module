package com.test.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {
    @GetMapping("/")
    public ResponseEntity<?> index(HttpServletRequest request, HttpServletResponse response) {

        Map<String, String> map = new HashMap<>();
        map.put("requestHeader", request.getHeader("Zuul"));
        System.out.println(request.getHeader("Zuul"));
        response.setHeader("header", "hi zuul this is /");

        return ResponseEntity.ok(map);
    }

    @PostMapping("/getInfo")
    public ResponseEntity<?> getInfo() {
        System.out.println("/getInfo 요청");

//        if (true) {
//            throw new IllegalStateException("예외 처리");
//        }

        return ResponseEntity.ok("아직 유저 값 없음");
    }
}

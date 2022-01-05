package com.example.interceptor.controller;

import com.example.interceptor.annotation.Auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/interceptorapi/private")
@RestController
@Auth
@Slf4j
public class PrivateController {

    @GetMapping("/hello")
    public String hello() {
        log.info("private hello controller");
        return "private hello";
    }
}

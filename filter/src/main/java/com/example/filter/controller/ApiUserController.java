package com.example.filter.controller;

import com.example.filter.dto.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/temp")
@Slf4j
public class ApiUserController {

    @PostMapping("")
    public User user(@RequestBody User user) {
        log.info("temp : {}, {}", user, user);
        return user;
    }
}
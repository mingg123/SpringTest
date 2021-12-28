package com.example.IOC;

import java.util.Base64;

import org.springframework.stereotype.Component;

@Component("base74Encoder")
public class Base64Encoder implements IEncoder {

    @Override
    public String encode(String message) {

        return Base64.getEncoder().encodeToString(message.getBytes());
    }

}

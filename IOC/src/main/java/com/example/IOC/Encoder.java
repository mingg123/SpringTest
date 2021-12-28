package com.example.IOC;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Encoder implements IEncoder {

    private IEncoder iEncoder;

    public void setIEncoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public Encoder(@Qualifier("base74Encoder") IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public String encode(String message) {
        return iEncoder.encode(message);
    }
}

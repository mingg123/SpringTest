package com.example.interceptor.config;

import com.example.interceptor.interceptor.AuthorInterceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

//@Authwird 를 하면 순한참조가 일어날 수 있고 이를 막기위해 @requireArgsConstructor를 사용함 
@RequiredArgsConstructor
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    private final AuthorInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor);
    }

}

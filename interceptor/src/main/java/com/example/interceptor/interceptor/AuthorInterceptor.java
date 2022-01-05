package com.example.interceptor.interceptor;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.interceptor.annotation.Auth;
import com.example.interceptor.exception.AuthException;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AuthorInterceptor implements HandlerInterceptor {

    // 여기서 true가 나지 않으면 controller 까지 가지 않음
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String url = request.getRequestURI();

        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI()).query(request.getQueryString()).build()
                .toUri();

        log.info("request url : {}", url);

        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("has annotation : {}", hasAnnotation);

        // 조건
        // 나의 서버tm 모두 public 으로 동작하는대 Auth권한을 가진 요청에서는 이름에 minji가 있는지 검사한다.
        if (hasAnnotation) {
            // 권한 체크
            String query = uri.getQuery();

            log.info("query: {}", query);
            if (query.equals("name=minji")) {
                return true;
            }
            throw new AuthException();
            // return false;
        }
        return true;
    }

    private boolean checkAnnotation(Object handler, Class clazz) {

        // resource javascript, html,
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        // annotation 이 달려있는지 체크
        HandlerMethod HandlerMethod = (HandlerMethod) handler;

        if (null != HandlerMethod.getMethodAnnotation(clazz)
                || null != HandlerMethod.getBeanType().getAnnotation(clazz)) {
            // Auth annotation이 있을때는 true
            return true;
        }
        return false;
    }
}

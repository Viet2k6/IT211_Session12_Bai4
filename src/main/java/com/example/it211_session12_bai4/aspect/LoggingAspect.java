package com.example.it211_session12_bai4.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* com.ex.bai4.controller.*.*(..))")
    public void beforeController(JoinPoint joinPoint) {

        log.info("Đang gọi method: {}", joinPoint.getSignature().getName());

        log.info("Danh sách tham số: {}",
                Arrays.toString(joinPoint.getArgs()));
    }

    @AfterThrowing(
            pointcut = "execution(* com.ex.bai4.service.*.*(..))",
            throwing = "ex"
    )
    public void afterThrowing(Exception ex) {

        log.warn("Service phát sinh ngoại lệ: {}", ex.getMessage());
    }

    @Around("execution(* com.ex.bai4.controller.*.*(..))")
    public Object aroundController(ProceedingJoinPoint joinPoint)
            throws Throwable {

        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        log.info(
                "Method {} thực thi trong {} ms",
                joinPoint.getSignature().getName(),
                (end - start)
        );

        return result;
    }
}
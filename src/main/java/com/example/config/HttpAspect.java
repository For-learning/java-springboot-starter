package com.example.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.example.controller.MyUserController.getGirl(..))")
    public void log() {
    }

    // @Before("execution(public * com.example.controller.MyUserController.getGirl(..))")
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // url
        logger.info("url = {}", request.getRequestURL());

        // method
        logger.info("url = {}", request.getMethod());

        // ip
        logger.info("url = {}", request.getRemoteAddr());

        // 类方法
        logger.info("url = {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        // 参数
        logger.info("url = {}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        logger.info("xxxx");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response = {}", object);
    }

}

package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Order(1)
@Aspect
@Component
public class SimpleAspect {
    private final static Logger logger = LoggerFactory.getLogger(SimpleAspect.class);

    // 定义切点
    @Pointcut("execution(public * com.example.controller.MyAspectController.simpleAspect(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("Hello ... SimpleAspect");

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
        logger.info("doAfter");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response = {}", object);
    }

}

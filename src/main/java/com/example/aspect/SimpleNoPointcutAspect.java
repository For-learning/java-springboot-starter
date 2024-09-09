package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(1)
@Aspect
@Component
public class SimpleNoPointcutAspect {
    private final static Logger logger = LoggerFactory.getLogger(SimpleNoPointcutAspect.class);

    // 如果只需要一个 Before 方法的时候，可以直接切入
    @Before("execution(public * com.example.controller.MyAspectController.simpleNoPointcutAspect(..))")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("Hello ... SimpleNoPointcutAspect");
        // 类方法
        logger.info("url = {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        // 参数
        logger.info("url = {}", joinPoint.getArgs());
    }
}

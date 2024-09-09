package com.example.aspect;

import com.example.annotation.TrialAspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnotationAspect {

    @Pointcut("@annotation(com.example.annotation.TrialAspect)")
    public void check() {
    }

    @Before("check() && @annotation(trialAspect)")
    public void doBefore(JoinPoint joinPoint, TrialAspect trialAspect) {
        System.out.println("I am annotation bound AOP!");

        String[] value = trialAspect.value();
        for (String v : value) {
            System.out.println(v);
        }
    }
}

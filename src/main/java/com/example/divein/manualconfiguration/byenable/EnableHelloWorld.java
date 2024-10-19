package com.example.divein.manualconfiguration.byenable;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(HelloWorldConfiguration.class) // 注解驱动方式 Since 3.0
//@Import(EnableHelloWorldImportSelector.class) // 接口编程方式 Since 3.1
public @interface EnableHelloWorld {
}

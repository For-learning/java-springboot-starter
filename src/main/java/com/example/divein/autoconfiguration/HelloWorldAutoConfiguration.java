package com.example.divein.autoconfiguration;

import com.example.divein.manualconfiguration.byconditiondymamic.ConditionalOnSystemProperty;
import com.example.divein.manualconfiguration.byenable.EnableHelloWorld;
import org.springframework.context.annotation.Configuration;

@Configuration // 注解装配
@EnableHelloWorld // 模块装配
@ConditionalOnSystemProperty(name = "name", value = "li") // 条件装配
public class HelloWorldAutoConfiguration {
}

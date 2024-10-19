package com.example.divein.manualconfiguration.byconditiondymamic;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example.divein.manualconfiguration.byconditiondymamic")
public class ConditionDynamicBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionDynamicBootstrap.class)
                .web(WebApplicationType.NONE) // 声明是一个非 web 程序
                .run(args);

        String bean = context.getBean("helloDynamic", String.class);
        System.out.println(bean);

        context.close();
    }
}

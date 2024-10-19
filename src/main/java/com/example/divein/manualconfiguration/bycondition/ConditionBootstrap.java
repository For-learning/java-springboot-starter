package com.example.divein.manualconfiguration.bycondition;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example.divein.manualconfiguration.bycondition")
public class ConditionBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionBootstrap.class)
                .web(WebApplicationType.NONE) // 声明是一个非 web 程序
                .profiles("Java8")
                .run(args);

        CalculateSrv bean = context.getBean(CalculateSrv.class);
        bean.sum(1);
        System.out.println(bean);

        context.close();
    }
}

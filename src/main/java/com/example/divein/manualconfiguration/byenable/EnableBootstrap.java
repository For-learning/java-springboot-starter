package com.example.divein.manualconfiguration.byenable;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@EnableHelloWorld
public class EnableBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableBootstrap.class)
                .web(WebApplicationType.NONE) // 声明是一个非 web 程序
                .run(args);

        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println(helloWorld);

        context.close();
    }
}

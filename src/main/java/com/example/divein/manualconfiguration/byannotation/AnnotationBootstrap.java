package com.example.divein.manualconfiguration.byannotation;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example.divein.manualconfiguration.byannotation")
public class AnnotationBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(AnnotationBootstrap.class)
                .web(WebApplicationType.NONE) // 声明是一个非 web 程序
                .run(args);

        MyFirstLevelRepository myFirstLevelRepository = context.getBean("myFirstLevelRepository", MyFirstLevelRepository.class);
        System.out.println(myFirstLevelRepository);

        context.close();
    }
}

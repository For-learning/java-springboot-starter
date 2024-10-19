package com.example.divein.lifecycle;

import com.example.DemoApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MySpringApplicationBootstrap {
    public static void main(String[] args) {
        // 1. 通过 SpringApplication 的静态方式运行
        //ConfigurableApplicationContext ctx = SpringApplication.run(MySpringApplicationBootstrap.class, args);

        // 2. 自定义 SpringApplication 方式运行
        //SpringApplication springApplication = new SpringApplication(MySpringApplicationBootstrap.class);
        //springApplication.setWebApplicationType(WebApplicationType.NONE);
        //springApplication.run(args);

        // 3. SpringApplicationBuilder Fluent Builder API 运行，通过链式操作简化代码
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(MySpringApplicationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);
        ctx.close();

        // 4. 手动配置源，不需要加 SpringBootApplication 注解
        //Set<String> sources = new HashSet<>();
        //sources.add(MySpringApplicationBootstrap.class.getName());
        //SpringApplication springApplication = new SpringApplication();
        //springApplication.setSources(sources);
        //springApplication.setWebApplicationType(WebApplicationType.NONE);
        //springApplication.run(args);
    }
}

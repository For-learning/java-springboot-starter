package com.example.divein.manualconfiguration.byenable;

import org.springframework.context.annotation.Bean;

public class HelloWorldConfiguration {
    @Bean
    public String helloWorld() {
        return "Hello World 2024!";
    }
}

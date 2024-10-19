package com.example.divein.manualconfiguration.byconditiondymamic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadConfig {
    @Bean
    @ConditionalOnSystemProperty(name = "user.name", value = "Li")
    public String helloDynamic() {
        return "Hello, Li!";
    }
}

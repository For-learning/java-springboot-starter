package com.example.divein.manualconfiguration.byconditiondymamic;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        String propName = String.valueOf(attributes.get("name"));
        String propValue = String.valueOf(attributes.get("value"));
        System.out.println(propName + "=" + propValue);

        return true;
    }
}

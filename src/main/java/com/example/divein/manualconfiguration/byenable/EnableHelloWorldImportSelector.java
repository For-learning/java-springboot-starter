package com.example.divein.manualconfiguration.byenable;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class EnableHelloWorldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 返回所有要装配的类名
        return new String[]{HelloWorldConfiguration.class.getName()};
    }
}

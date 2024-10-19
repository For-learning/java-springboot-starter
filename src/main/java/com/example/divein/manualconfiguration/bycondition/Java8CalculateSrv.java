package com.example.divein.manualconfiguration.bycondition;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("Java8")
@Service
public class Java8CalculateSrv implements CalculateSrv {
    @Override
    public Integer sum(Integer... values) {
        System.out.println("Profile Java8");
        return 8;
    }
}

package com.example.divein.manualconfiguration.bycondition;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("Java7")
@Service
public class Java7CalculateSrv implements CalculateSrv {
    @Override
    public Integer sum(Integer... values) {
        System.out.println("Profile Java7");
        return 7;
    }
}

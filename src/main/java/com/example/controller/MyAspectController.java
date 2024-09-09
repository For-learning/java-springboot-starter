package com.example.controller;

import com.example.annotation.TrialAspect;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAspectController {

    @GetMapping(value = "/simpleAspect/{id}")
    public Object simpleAspect(@PathVariable("id") Integer id) {
        return "Hello simpleAspect" + id;
    }

    @GetMapping(value = "/simpleNoPointcutAspect/{id}")
    public Object simpleNoPointcutAspect(@PathVariable("id") Integer id) {
        return "Hello simpleNoPointcutAspect" + id;
    }

    @TrialAspect(value = {"a", "b", "c"})
    @GetMapping(value = "/annotationPointcutAspect/{id}")
    public Object annotationPointcutAspect(@PathVariable("id") Integer id) {
        return "Hello annotationPointcutAspect" + id;
    }
}

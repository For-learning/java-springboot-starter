package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.Resource;

@RestController
public class HelloController {

	@Autowired
	private Resource resource;

	@RequestMapping("/hello")
	public Object hello() {
		// 1/0 测试异常捕获
		return "Hello Spring Boot~";
	}
	
	@RequestMapping("/getResource")
	public Object getResource() {
		Resource bean = new Resource();
		BeanUtils.copyProperties(resource, bean);
		
		return bean;
	}

}

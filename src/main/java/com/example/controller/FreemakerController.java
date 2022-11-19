package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pojo.Resource;

@RequestMapping("/ftl")
@Controller
public class FreemakerController {
	
	@Autowired
	private Resource resource;
	
	@RequestMapping("/index")
	public String index(ModelMap map) {
		map.addAttribute("resource", resource);
		return "freemaker/index";
	}
	
	@RequestMapping("/center")
	public String center(ModelMap map) {
		map.addAttribute("resource", resource);
		return "freemaker/center/center";
	}

}

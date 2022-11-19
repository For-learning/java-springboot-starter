package com.example.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pojo.User;

// @RestController = @Controller + @ResponseBody

@RequestMapping("/user")
@Controller
public class UserController {

	@RequestMapping("/getUser")
	@ResponseBody
	public User getUser() {
		User u = new User();
		u.setName("Xiaoming");
		u.setAge(10);
		u.setBirthday(new Date());
		u.setPassword("xxx");
		u.setDesc("xyz");

		return u;
	}

}

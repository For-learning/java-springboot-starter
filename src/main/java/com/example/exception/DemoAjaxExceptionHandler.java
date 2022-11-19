package com.example.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.pojo.Resource;

// Ajax 的异常补货类
//@RestControllerAdvice
public class DemoAjaxExceptionHandler {
//	@ExceptionHandler(value = Exception.class)
	public Object defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {

		e.printStackTrace();
		Resource bean = new Resource();
		bean.setName("xxx");
		bean.setWebsite("xxx");
		bean.setLanguage("CN");
		return bean;
	}
}

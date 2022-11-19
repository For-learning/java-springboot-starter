package com.example.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.example.pojo.Resource;

@ControllerAdvice
public class DemoExceptionHandler {

    public static final String DEMO_ERROR_VIEW = "error";

    // 传统的异常处理方式
//	@ExceptionHandler(value = Exception.class)
//	public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
//
//		e.printStackTrace();
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("exception", e);
//		mav.addObject("url", request.getRequestURL());
//		mav.setViewName(DEMO_ERROR_VIEW);
//		return mav;
//	}

    /**
     * 自定义异常要继承 RuntimeException，因为 Spring 框架不会对 Exception 做事物回滚
     */

    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception {
        e.printStackTrace();

        if (isAjax(request)) {
            Resource bean = new Resource();
            bean.setName("xxx");
            bean.setWebsite("xxx");
            bean.setLanguage("CN");
            return bean;
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", request.getRequestURL());
            mav.setViewName(DEMO_ERROR_VIEW);
            return mav;
        }
    }

    // 判断是否是 ajax 请求
    public static boolean isAjax(HttpServletRequest httpRequest) {
        return (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest".equals(httpRequest.getHeader("X-Requested-With").toString()));
    }

}

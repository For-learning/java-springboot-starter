package com.example.controller;

import com.example.pojo.Girl;
import com.example.pojo.Resource;
import com.example.pojo.Result;
import com.example.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

//@RequestMapping("/myUser")
@RestController
public class MyUserController {

    @Autowired
    private Resource resource;

    // 传递 path 参数返回结果
    @GetMapping(value = "/getGirl/{id}")
    public Object getGirl(@PathVariable("id") Integer id) {
        return "Hello my girl" + id;
    }

    // 传递 path 参数和 request param 参数返回结果: form-data
    @PutMapping(value = "/updateGirl/{id}")
    public Object updateGirl(@PathVariable("id") Integer id,
                             @RequestParam("cup") String cup,
                             @RequestParam("age") Integer age
    ) {
        return "Hello my girl " + id + " " + cup;
    }

    // 通过实体类进行参数验证: form-data
    @PostMapping(value = "/girls")
    public Result<Girl> getGirlObject(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errMsg = bindingResult.getFieldError().getDefaultMessage();
            System.out.println(errMsg);
            return ResultUtil.error(1, errMsg);
        }
        Girl girl2 = new Girl();
        girl2.setId(123);
        girl2.setAge(18);
        girl2.setCup("cpu");
        return ResultUtil.success(girl);
    }
}

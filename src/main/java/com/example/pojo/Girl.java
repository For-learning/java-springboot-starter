package com.example.pojo;

import javax.validation.constraints.Min;

public class Girl {
    private Integer id;
    private String cup;
    @Min(value = 18, message = "未成年少女")
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCup() {
        return cup;
    }

    public void setCup(String cup) {
        this.cup = cup;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

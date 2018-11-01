package com.imooc.gril.controller;

import com.imooc.gril.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello", method = {RequestMethod.GET})
    public String say() {
        return "Hello SpringBoot!";
    }

    @RequestMapping(value = "/cupSize", method = {RequestMethod.GET})
    public String cupSize() {
        return cupSize + age;
        //return content;
    }

    @RequestMapping(value = "/prop", method = {RequestMethod.GET})
    public String prop() {
        return girlProperties.getCupSize();
    }
}

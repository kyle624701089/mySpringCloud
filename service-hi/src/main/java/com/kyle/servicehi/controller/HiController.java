package com.kyle.servicehi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunkai-019
 * @title: HiController
 * @projectName mySpringCloud
 * @description: TODO
 * @date 2021/6/25 21:06
 */
@RestController
@RequestMapping
public class HiController {

    @GetMapping(value = "/hi")
    public String hi(@RequestParam("name") String name) {
        System.out.println("有请求访问进来了。。。。");
        return "Hello "+name+", welcome to Hi Service.";
    }
}

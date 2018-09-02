package com.kyle.serviceribbon.controller;

import com.kyle.serviceribbon.service.serviceImpl.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ ClassName: HelloController
 * @ Description: TODO
 * @ author: Administrator
 * @ date: 2018/9/2 17:14
 * @ version: 1.0
 **/
@RestController
public class HelloController {
    @Resource
    private HelloService helloService;

    @GetMapping(value = "/hello")
    public String hello(@RequestParam String name) {
        return helloService.helloService(name);
    }
}

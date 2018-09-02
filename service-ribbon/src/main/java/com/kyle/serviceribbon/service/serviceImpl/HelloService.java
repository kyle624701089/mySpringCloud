package com.kyle.serviceribbon.service.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ ClassName: HelloService
 * @ Description: TODO
 * @ author: Administrator
 * @ date: 2018/9/2 17:11
 * @ version: 1.0
 **/
@Service
public class HelloService {
    @Resource
    public RestTemplate restTemplate;

    public String helloService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }
}

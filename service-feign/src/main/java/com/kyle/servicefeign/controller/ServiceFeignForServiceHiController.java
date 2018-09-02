package com.kyle.servicefeign.controller;

import com.kyle.servicefeign.service.ServiceFeignForServiceHi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ ClassName: ServiceFeignForServiceHiController
 * @ Description: TODO
 * @ author: Administrator
 * @ date: 2018/9/2 21:09
 * @ version: 1.0
 **/
@RestController
public class ServiceFeignForServiceHiController {
    @Resource
    private ServiceFeignForServiceHi serviceHi;

    @GetMapping(value = "/hi")
    public String sayHiFromServiceHi(@RequestParam String name) {
        return serviceHi.getMsgFromServiceHi(name);
    }
}

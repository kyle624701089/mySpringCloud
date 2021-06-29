package com.kyle.servicefeign.controller;

import com.kyle.servicefeign.service.DemoHiServiceFeign;
import com.kyle.servicefeign.service.ServiceFeignForServiceHi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @Resource
    private DemoHiServiceFeign demoHiServiceFeign;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/hi")
    public String sayHiFromServiceHi(@RequestParam String name) {
        return serviceHi.getMsgFromServiceHi(name);
    }

    @GetMapping(value = "/demoHi/{name}")
    public String demoHiService(@PathVariable(value = "name") String name) {
        return demoHiServiceFeign.demoHiServiceFeign(name);
    }

    @GetMapping(value = "/restTemplate/{name}")
    public String restTemplateName(@PathVariable(value = "name") String name) {
        return restTemplate.getForObject("http://demoService/demoHi/" + name, String.class);
    }
}

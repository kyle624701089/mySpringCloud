package com.kyle.servicefeign.service;

import com.kyle.servicefeign.service.impl.DemoHiServiceFeignImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author sunkai-019
 * @title: DemoHiServiceFeign
 * @projectName mySpringCloud
 * @description: TODO
 * @date 2021/6/25 22:27
 */
@FeignClient(value = "demoService")
public interface DemoHiServiceFeign {

    @RequestMapping(value = "/api/app/marketActivity/demoHi/{name}", method = RequestMethod.GET)
    String demoHiServiceFeign(@PathVariable(value = "name") String name);
}

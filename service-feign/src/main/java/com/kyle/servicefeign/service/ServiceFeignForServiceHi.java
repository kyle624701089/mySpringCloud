package com.kyle.servicefeign.service;

import com.kyle.servicefeign.service.impl.ServiceFeignForServiceHiImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi",fallback = ServiceFeignForServiceHiImpl.class)
public interface ServiceFeignForServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String getMsgFromServiceHi(@RequestParam(value = "name") String name);
}

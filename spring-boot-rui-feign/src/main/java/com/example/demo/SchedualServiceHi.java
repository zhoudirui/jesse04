package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by kevin on 2017/12/21.
 */
@FeignClient(value="service-hi")
public interface SchedualServiceHi {
    @RequestMapping(value="/hi",method= RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value="name" ) String name);
}

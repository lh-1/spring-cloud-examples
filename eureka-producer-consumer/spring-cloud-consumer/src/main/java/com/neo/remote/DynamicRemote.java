package com.neo.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "dynamic-datasource-server")
public interface DynamicRemote {

    @RequestMapping(value = "/eureka/findSecList/{secId}", method = RequestMethod.POST)
    Object findSecList(@PathVariable("secId") Long secId);

}

package com.neo.controller;

import com.alibaba.fastjson.JSONObject;
import com.neo.remote.DynamicRemote;
import com.neo.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author msh11535
 */
@RestController
public class ConsumerController {

    @Autowired
    private HelloRemote helloRemote;
    @Autowired
    private DynamicRemote dynamicRemote;

    @RequestMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return helloRemote.hello(name);
    }

    @RequestMapping(value = "/eureka/findSecList/{secId}")
    public Object findSecList(@PathVariable("secId") Long secId) {
        Object result = dynamicRemote.findSecList(secId);
        return JSONObject.toJSONString(result);
    }

}
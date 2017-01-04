package com.in28minutes.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.configuration.BasicConfiguration;

@RestController
public class WelcomeController {

    @Autowired
    private SomeDependency someDependency;

    @Autowired
    private BasicConfiguration configuration;

    @RequestMapping("/")
    public String index() {
        return someDependency.getSomething();
    }

    @RequestMapping("/dynamic-configuration")
    public Map dynamicConfiguration() {
        // Not the best practice to use a map to store differnt types!
        Map map = new HashMap();
        map.put("message", configuration.getMessage());
        map.put("number", configuration.getNumber());
        map.put("key", configuration.isValue());
        return map;
    }

}

@Component
class SomeDependency {

    @Value("${welcome.message}")
    private String welcomeMessage;

    public String getSomething() {
        return welcomeMessage;
    }

}

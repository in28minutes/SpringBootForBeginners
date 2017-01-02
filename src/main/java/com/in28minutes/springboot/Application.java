package com.in28minutes.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

    }

    @RestController
    class SomeBean {

        @Autowired
        private SomeDependency someDependency;

        @RequestMapping("/")
        public String index() {
            return someDependency.getSomething();
        }

    }

    @Component
    class SomeDependency {

        public String getSomething() {
            return "Hello! Welcome!";
        }

    }

}
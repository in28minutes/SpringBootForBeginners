package com.in28minutes.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        System.out.println(ctx.getBean(SomeBean.class).calculateSomething());

    }

    @Component
    class SomeBean {

        @Autowired
        private SomeDependency someDependency;

        public String calculateSomething() {
            // I'm a lazy bugger. Skipping calculation
            return someDependency.getSomething();
        }
    }

    @Component
    class SomeDependency {

        public String getSomething() {
            return "something";
        }

    }

}
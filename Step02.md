##What You Will Learn during this Step:
- Lets add a RestController with a dependency and see Spring Boot Magic live

##Quick Spring and Spring MVC Primer
- What is dependency?
- @Component
- @Autowired
- @RestController

## Useful Snippets and References

First Snippet

```
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

```

## Files List
### /pom.xml
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.in28minutes</groupId>
    <artifactId>springboot-for-beginners-example</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>Your First Spring Boot Example</name>
    <packaging>war</packaging>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.0.RELEASE</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>

    <properties>
        <java.version>1.8</java.version>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>
```
### /src/main/java/com/in28minutes/springboot/Application.java
```
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
```
##What You Will Learn during this Step:
- A Deep Dive into Autoconfiguration
 - spring-boot-autoconfigure-1.4.0.RELEASE.jar
  - /META-INF/spring.factories
  - Package org.springframework.boot.autoconfigure
- Lets look at the log in debug mode!
- Examples
 - JdbcTemplateAutoConfiguration
 - HttpMessageConvertersAutoConfiguration
- Programming Tips 
 - Understand Design Patterns
  - https://www.youtube.com/watch?v=Vp7q_pE7Fzg
 - Understand Modern Development Practices
  - https://www.youtube.com/watch?v=0Kqzfyp-w4s

## Useful Snippets and References
```
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);

        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
```

##What You Will Learn during this Step:
- Configure different user roles for survey and other services
- Update integration tests
- Update unit tests

## Useful Snippets and References
First Snippet
```
package com.in28minutes.springboot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication().withUser("user1").password("secret1")
                .roles("USER").and().withUser("admin1").password("secret1")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests().antMatchers("/surveys/**")
        .hasRole("USER").antMatchers("/users/**").hasRole("USER")
                .antMatchers("/**").hasRole("ADMIN").and().csrf().disable()
                .headers().frameOptions().disable();
    }
}
```
Second Snippet
```
    HttpHeaders headers = createHeaders("user1", "secret1");

    HttpHeaders createHeaders(String username, String password) {
        return new HttpHeaders() {
            {
                String auth = username + ":" + password;
                byte[] encodedAuth = Base64.encode(auth.getBytes(Charset
                        .forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);
                set("Authorization", authHeader);
            }
        };
    }

```

Third Snippet
```
@WebMvcTest(value = SurveyController.class, secure = false)
```
## Exercises

## Files List
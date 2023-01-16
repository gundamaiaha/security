package com.example.csrfApp.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] CSRF_IGNORE = {"/login/**"};
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .httpBasic()
//                .and()
//                .csrf() // csrf config starts here
//                .ignoringAntMatchers(CSRF_IGNORE) // URI where CSRF check will not be applied
//                .csrfTokenRepository(csrfTokenRepository()) // defines a repository where tokens are stored
//                .and()
//                .addFilterAfter(new CustomCsrfFilter(), CsrfFilter.class); //
//        http.authorizeRequests().anyRequest().authenticated();

        http.httpBasic()
                .and().csrf().disable();


    }

//    private CsrfTokenRepository csrfTokenRepository() {
//        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
//        repository.setHeaderName(CustomCsrfFilter.CSRF_COOKIE_NAME);
//        return repository;
//    }
}

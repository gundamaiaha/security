package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        return http.authorizeHttpRequests(
                        requests -> requests.requestMatchers("/contact", "/notices").permitAll()
                                .anyRequest().authenticated()
                ).formLogin(withDefaults())
                .httpBasic(withDefaults())
                .build();


//        http.authorizeHttpRequests(
//                requests -> requests
//                        .requestMatchers("/myAccounts", "/myBalance", "/myCards", "/myLoans").authenticated()
//                        .requestMatchers("/contact", "/notices").permitAll()
//        );
//
//        //permitAll
////        http.authorizeHttpRequests(requests -> requests.anyRequest().permitAll());
//
//        //denyAll
////        http.authorizeHttpRequests(requests -> requests.anyRequest().denyAll());
//
//
//        http.formLogin(withDefaults());
//        http.httpBasic(withDefaults());
//




    }
}

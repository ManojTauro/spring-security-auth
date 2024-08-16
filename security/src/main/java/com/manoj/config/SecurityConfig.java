package com.manoj.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

    private final String[] authenticated = {"/api/v1/accounts", "/api/v1/balance", "/api/v1/cards", "/api/v1/loans"};
    private final String[] permitted = {"/api/v1/contact", "/api/v1/notice", "/error"};

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (requests) -> requests
                        .requestMatchers(authenticated).authenticated()
                        .requestMatchers(permitted).permitAll()
        );

        http.formLogin(withDefaults());
        http.httpBasic(withDefaults());
        return http.build();
    }
}

package com.taskconnect.serviceprovider.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // CSRF is disabled for early stages of the project. This might change later.
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
                .authorizeHttpRequests(request ->
                        request
                                // Authorization will be properly set when roles and authorities are defined.
                                .anyRequest().permitAll())
                .formLogin(form -> form.disable());
        return http.build();
    }
}

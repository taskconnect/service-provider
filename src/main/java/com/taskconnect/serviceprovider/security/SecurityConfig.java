package com.taskconnect.serviceprovider.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // By default, withDefaults() uses a Bean by the name of corsConfigurationSource.
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(request ->
                        request
                                // Any request is being authorized as there's no authentication mechanism implemented.
                                .anyRequest().permitAll())
                .formLogin(form -> form.disable())
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
                // There's no login, so there's no need to keep CSRF activated, as it is by default.
                .csrf(csrf -> csrf.disable());
        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

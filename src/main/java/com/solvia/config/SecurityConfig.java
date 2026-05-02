package com.solvia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    	http
        .csrf(csrf -> csrf.disable())
        .cors(cors -> {})

        .addFilterBefore(new JwtAuthFilter(), UsernamePasswordAuthenticationFilter.class)

        .authorizeHttpRequests(auth -> auth
        	.requestMatchers("/api/usuarios/**").permitAll()
            .requestMatchers("/api/auth/**").permitAll()
            .requestMatchers("/api/usuarios/create").permitAll()
            .requestMatchers("/admin/**").hasRole("ADMIN")
            .requestMatchers("/api/usuarios/**").hasAnyRole("ADMIN", "AUXILIAR")
            .anyRequest().authenticated()
        );

        return http.build();
    }
}
package com.spring_ecommerce_api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.beans.BeanProperty;


@Configuration
@EnableWebSecurity
public class SpringBootSecurity {

    //inyectamos
    @Autowired
    private UserDetailsService userDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Evita bloqueos en formularios Thymeleaf
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/administrador/**").hasRole("ADMIN") // Protege rutas de admin
                        .requestMatchers("/productos/**").hasRole("ADMIN")
                        .anyRequest().permitAll() // Todo lo demás es público
                )
                .formLogin(form -> form
                        .loginPage("/usuario/login").permitAll() // Tu pantalla de login propia
                        .defaultSuccessUrl("/usuario/acceder", true).permitAll()
                );

        return http.build();
    }


}

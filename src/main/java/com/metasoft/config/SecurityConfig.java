/*package com.metasoft.config;

import com.api.MetaSoft.service.LoginDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final LoginDetailsService loginDetailsService;

    public SecurityConfig(LoginDetailsService loginDetailsService) {
        this.loginDetailsService = loginDetailsService;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(loginDetailsService);
        auth.setPasswordEncoder(new BCryptPasswordEncoder());
        return auth;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
            .authenticationProvider(authenticationProvider())
            .build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/",               // permite acesso à raiz
                    "/index",          // permite /index
                    "/login",          // permite acesso à tela de login (GET)
                    "/css/**",         // permite CSS
                    "/js/**",
                    "/images/**",
                    "/webjars/**"
                ).permitAll()
                .anyRequest().authenticated() // tudo mais precisa de login
            )
            .formLogin(form -> form
                .loginPage("/login")                // sua página customizada
                .loginProcessingUrl("/login")       // POST do formulário
                .defaultSuccessUrl("/admin", true)  // redirecionamento após login
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/index")         // redireciona ao fazer logout
                .permitAll()
            );

        return http.build();
    }
}*/

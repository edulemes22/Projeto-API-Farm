package com.example.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ConfiguracaoSeguranca extends WebSecurityConfigurerAdapter {

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()

                .withUser("admin").password("$2a$10$PdgJfOQ6WKAaQWvCGBLwY.aZBZdCMvLK8iE09GEjWFVgOnGtNisem").roles("ADMIN");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests()

                .antMatchers("/farmacia/**").permitAll()

                .antMatchers("/funcionario/**").permitAll()

                .anyRequest().authenticated()

                .and()
                .formLogin()

                .loginPage("/login")

                .permitAll()

                .defaultSuccessUrl("/home")

                .and()
                .logout()

                .permitAll()

                .and()
                .rememberMe();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/webjars/bootstrap/4.0.0/css/bootstrap.min.css", "/css/style.css");

    }
}

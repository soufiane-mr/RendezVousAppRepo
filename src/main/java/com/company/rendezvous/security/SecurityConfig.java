package com.company.rendezvous.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication().withUser("user1").password("{noop}123456").roles("USER");
       auth.inMemoryAuthentication().withUser("admin").password("{noop}123456").roles("USER","ADMIN");
    }


    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();
        http.authorizeRequests().anyRequest().authenticated();
    }
}

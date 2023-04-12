package com.instagramdemo.instagramDemo.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Log4j2
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().disable() .csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/home").permitAll()
                .antMatchers("/admin").permitAll()
                .antMatchers("/likes").hasRole("USER")
                .antMatchers("/message").hasRole("USER")
                .antMatchers("/profile").hasRole("USER")
                .anyRequest().permitAll();

        http.rememberMe();

        http.formLogin()
                .permitAll();

    }

}

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
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/home").authenticated()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/likes").hasRole("USER")
                .antMatchers("/message").hasRole("USER")
                .antMatchers("/profile").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated();

        http.rememberMe();

        http.formLogin()
                .permitAll();

    }

}

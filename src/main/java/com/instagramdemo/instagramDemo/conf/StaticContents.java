package com.instagramdemo.instagramDemo.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
@EnableWebMvc
public class StaticContents implements WebMvcConfigurer {

    private final String[][] staticMappings = {
            {"/static/css/**", "classpath:/static/css/"},
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        Arrays.stream(staticMappings)
                .forEach(mapping ->
                        registry.addResourceHandler(mapping[0]).addResourceLocations(mapping[1])
                );
    }
}

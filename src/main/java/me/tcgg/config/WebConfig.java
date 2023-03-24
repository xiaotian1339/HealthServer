package me.tcgg.config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// @Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(apiInterceptor).addPathPatterns("/api/v1/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }



}

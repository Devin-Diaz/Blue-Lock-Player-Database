package com.diaz.egoist_engine_backend.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://blue-lock-player-database.vercel.app")  // Vercel frontend URL without the trailing slash
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Add all HTTP methods you want to allow
                .allowedHeaders("*")  // Allow all headers or specify the headers you want to allow
                .allowCredentials(true);  // If you need to allow credentials (e.g., cookies, authorization headers)
    }
}
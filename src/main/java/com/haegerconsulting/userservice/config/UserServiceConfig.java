package com.haegerconsulting.userservice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.haegerconsulting.userservice")
@PropertySource(value = "config.yaml")
@EnableWebMvc
public class UserServiceConfig {
}

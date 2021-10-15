package com.acn.patient.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public ObjectMapper  getMapper(){
        return new ObjectMapper();
    }
}

package dev.umang.productservice_27_08.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestTemplateConfiguration {
    @Bean //Spring beans are spring objects which are to be managed by the spring container
    public RestTemplate createRestTemplate(){

        return new RestTemplate();
    }
}

package dev.umang.productservice_27_08.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {
    @Bean //Spring beans are spring objects which are to be managed by the spring container
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public RedisTemplate<String, Object> createRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}

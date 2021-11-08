package crud_redis_ntnh_18036971;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class CrudRedisNtnh18036971Application {

    public static void main(String[] args) {
        SpringApplication.run(CrudRedisNtnh18036971Application.class, args);
    }

    @Bean
    LettuceConnectionFactory jedisLettuceConnectionFactory(){
        return new LettuceConnectionFactory();
    }

    @Bean
    RedisTemplate redisTemplate(){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisLettuceConnectionFactory());
        return redisTemplate;
    }
}

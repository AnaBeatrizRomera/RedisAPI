package com.example.leontisredis.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final RedisTemplate<String, Object> redisTemplate;

    public UsuarioService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // Incrementar a atividade do usuário
    public void incrementUserActivity() {
        redisTemplate.opsForValue().increment("atividade");
    }

    // Decrementar a atividade do usuário
    public void decrementUserActivity() {
        redisTemplate.opsForValue().decrement("atividade");
    }

    // Obter a contagem de atividade do usuário
    public Integer getUserActivity() {
            String countStr = (String) redisTemplate.opsForValue().get("atividade");
            Integer count = countStr != null ? Integer.valueOf(countStr) : 0;
            return count;

    }
}

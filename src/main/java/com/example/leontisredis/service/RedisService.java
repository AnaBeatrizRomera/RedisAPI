package com.example.leontisredis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    private final String COUNTER_KEY = "contadorAtividade";

    @Autowired
    private StringRedisTemplate redisTemplate;

    public Long incrementCounter() {
        return redisTemplate.opsForValue().increment(COUNTER_KEY);
    }

    public Long decrementCounter() {
        return redisTemplate.opsForValue().decrement(COUNTER_KEY);
    }

    public Long getCounterValue() {
        String value = redisTemplate.opsForValue().get(COUNTER_KEY);
        return (value != null) ? Long.parseLong(value) : 0L;
    }
}

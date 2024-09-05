package com.example.leontisredis.controller;

import com.example.leontisredis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/counter")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @PostMapping("/increment")
    public Long incrementCounter() {
        return redisService.incrementCounter();
    }

    @PostMapping("/decrement")
    public Long decrementCounter() {
        return redisService.decrementCounter();
    }

    @GetMapping
    public Long getCounterValue() {
        return redisService.getCounterValue();
    }
}

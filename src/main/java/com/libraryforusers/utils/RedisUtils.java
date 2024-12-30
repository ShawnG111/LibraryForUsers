package com.libraryforusers.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    public Boolean expire(String key, long seconds) {
        return redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    public void set(String key, String value, long seconds) {
        if(seconds > 0){
            redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
        }else{
            redisTemplate.opsForValue().set(key, value);
        }
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

}
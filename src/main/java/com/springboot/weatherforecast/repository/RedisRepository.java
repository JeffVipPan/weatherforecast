package com.springboot.weatherforecast.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * Created by ZJ on 2017/8/3.
 */
@Repository
public class RedisRepository {

    private final RedisTemplate redisTemplate;

    @Autowired
    public RedisRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(Object key,Object object){
        redisTemplate.opsForValue().set(key,object);
    }

    public void save(Object key,Object object,Integer time){
        redisTemplate.opsForValue().set(key,object,time, TimeUnit.SECONDS);
    }

    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public void delete(String key){
        redisTemplate.delete(key);
    }
}

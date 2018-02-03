package com.springboot.weatherforecast.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.weatherforecast.repository.RedisRepository;
import com.springboot.weatherforecast.service.WeatherDataService;
import com.springboot.weatherforecast.vo.WeatherResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author 潘峰
 * @date 03/02/2018 4:44 PM
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private static String WEATHER_URL = "http://www.sojson.com/open/api/weather/json.shtml";

    private static final int TIME_OUT = 10;


    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherDataServiceImpl.class);

    private final RestTemplate restTemplate;
    private final RedisRepository redisRepository;
    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public WeatherDataServiceImpl(RedisRepository redisRepository, RestTemplate restTemplate, StringRedisTemplate stringRedisTemplate) {
        this.redisRepository = redisRepository;
        this.restTemplate = restTemplate;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public WeatherResponse getDataByCityName(String name) throws IOException {
        String URL = WEATHER_URL + "?city=" + name;
        String key = URL;
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        if (stringRedisTemplate.hasKey(key)) {
            LOGGER.info("redis has data");
            ObjectMapper mapper = new ObjectMapper();
            String s = valueOperations.get(key);
            return mapper.readValue( s, WeatherResponse.class);
        } else {
            LOGGER.info("redis not data");
            ResponseEntity<String> entity = restTemplate.getForEntity(URL, String.class);
            ObjectMapper mapper = new ObjectMapper();
            valueOperations.set(key, entity.getBody(), TIME_OUT, TimeUnit.SECONDS);
            redisRepository.save(key, entity.getBody());
            return mapper.readValue( entity.getBody(), WeatherResponse.class);
        }
    }



    @Override
    public WeatherResponse getDataByCityId(String id) {
        return null;
    }
}

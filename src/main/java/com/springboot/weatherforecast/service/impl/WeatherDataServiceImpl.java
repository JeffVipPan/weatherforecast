package com.springboot.weatherforecast.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.weatherforecast.service.WeatherDataService;
import com.springboot.weatherforecast.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.DataInput;
import java.io.IOException;

/**
 * @author 潘峰
 * @date 03/02/2018 4:44 PM
 */
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private static String WEATHER_URL = "http://www.sojson.com/open/api/weather/json.shtml";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherResponse getDataByCityName(String name) throws IOException {
        String URL = WEATHER_URL + "?city=" + name;
        ResponseEntity<String> entity = restTemplate.getForEntity(URL, String.class);

        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weatherResponse = mapper.readValue( entity.getBody(), WeatherResponse.class);
        return weatherResponse;
    }



    @Override
    public WeatherResponse getDataByCityId(String id) {
        return null;
    }
}

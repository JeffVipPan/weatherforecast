package com.springboot.weatherforecast.service.impl;

import com.springboot.weatherforecast.service.WeatherDataService;
import com.springboot.weatherforecast.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    public WeatherResponse getDataByCityName(String name) {
        String URL = WEATHER_URL + "city=" + name;
        ResponseEntity<WeatherResponse> entity = restTemplate.getForEntity(URL, WeatherResponse.class);
        return entity.getBody();
    }



    @Override
    public WeatherResponse getDataByCityId(String id) {
        return null;
    }
}

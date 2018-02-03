package com.springboot.weatherforecast.api;

import com.springboot.weatherforecast.service.WeatherDataService;
import com.springboot.weatherforecast.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author 潘峰
 * @date 03/02/2018 4:56 PM
 */
@RestController
@RequestMapping("/weather")
public class WeatherApi {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping(value = "/cities/{cityName}")
    public WeatherResponse weather(@PathVariable String cityName) throws IOException {
        return weatherDataService.getDataByCityName(cityName);
    }
}

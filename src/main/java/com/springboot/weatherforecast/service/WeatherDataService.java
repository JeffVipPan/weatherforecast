package com.springboot.weatherforecast.service;

import com.springboot.weatherforecast.vo.WeatherResponse;

/**
 * @author 潘峰
 * @date 03/02/2018 4:44 PM
 */
public interface WeatherDataService {

    WeatherResponse getDataByCityId(String id);

    WeatherResponse getDataByCityName(String name);

}

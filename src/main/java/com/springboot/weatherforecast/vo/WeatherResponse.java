package com.springboot.weatherforecast.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 潘峰
 * @date 03/02/2018 4:40 PM
 */
@Getter
@Setter
public class WeatherResponse implements Serializable {
    private final static long serialVersionUID = 1L;

    private String date;
    private String city;
    private Integer count;

    private Weather data;
    private Integer status;
    private String message;

}

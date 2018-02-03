package com.springboot.weatherforecast.vo;

import java.io.Serializable;

/**
 * @author 潘峰
 * @date 03/02/2018 4:40 PM
 */
public class WeatherResponse implements Serializable {
    private final static long serialVersionUID = 1L;

    private Weather date;
    private Integer status;
    private String desc;


}

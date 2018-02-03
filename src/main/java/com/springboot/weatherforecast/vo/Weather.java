package com.springboot.weatherforecast.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author 潘峰
 * @date 03/02/2018 4:29 PM
 */
@Getter
@Setter
public class Weather implements Serializable {

    private final static long serialVersionUID = 1L;

    private String city;

    private String aqi;

    private String ganmao;

    private String wendu;

    private Yeaterday yeaterday;

    private List<Forecast> forecasts;


}

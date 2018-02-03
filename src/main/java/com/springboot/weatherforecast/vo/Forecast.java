package com.springboot.weatherforecast.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 潘峰
 * @date 03/02/2018 4:30 PM
 */
@Setter
@Getter
public class Forecast implements Serializable {

    private final static long serialVersionUID = 1L;
    
    
    private String date;

    private String high;

    private String fengli;

    private String low;

    private String fengxiang;

    private String type;



}

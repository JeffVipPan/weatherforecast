package com.springboot.weatherforecast.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author 潘峰
 * @date 03/02/2018 4:30 PM
 */
@Getter
@Setter
public class Yeaterday implements Serializable {
    private final static long serialVersionUID = 1L;

    private String date;

    private String high;

    private String fx;

    private String low;

    private String fl;

    private String type;
}

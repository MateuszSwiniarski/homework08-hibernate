package com.rodzyn.homework08hibernate.model.weather;

import javax.persistence.*;

@Entity
@Table(name = "weather_details")
public class WeatherDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String cloud;
    private String wind;
    private String minTemp;
    private String maxTemp;
    private String temp;
    private String airPressure;
    private Integer predictability;

    public WeatherDetail() {
    }

    public WeatherDetail(String title) {
        this.title = title;
    }

        public WeatherDetail(String title, String cloud, String wind, String minTemp, String maxTemp, String temp, String airPressure, Integer predictability) {
        this.title = title;
        this.cloud = cloud;
        this.wind = wind;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.temp = temp;
        this.airPressure = airPressure;
        this.predictability = predictability;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCloud() {
        return cloud;
    }

    public void setCloud(String cloud) {
        this.cloud = cloud;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        maxTemp = maxTemp;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(String airPressure) {
        this.airPressure = airPressure;
    }

    public Integer getPredictability() {
        return predictability;
    }

    public void setPredictability(Integer predictablility) {
        this.predictability = predictablility;
    }

    @Override
    public String toString() {
        return "WeaterDetails{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cloud='" + cloud + '\'' +
                ", wind='" + wind + '\'' +
                ", minTemp='" + minTemp + '\'' +
                ", MaxTemp='" + maxTemp + '\'' +
                ", temp='" + temp + '\'' +
                ", airPressure=" + airPressure +
                ", predictablility='" + predictability + '\'' +
                '}';
    }
}

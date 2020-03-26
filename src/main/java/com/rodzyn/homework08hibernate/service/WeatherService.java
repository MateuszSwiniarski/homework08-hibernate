package com.rodzyn.homework08hibernate.service;

import com.rodzyn.homework08hibernate.model.weather.ConsolidatedWeather;
import com.rodzyn.homework08hibernate.model.weather.WeaterDetails;
import com.rodzyn.homework08hibernate.model.weather.Weather;
import com.rodzyn.homework08hibernate.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private WeatherRepository weatherRepo;

    @Autowired
    public WeatherService(WeatherRepository weatherRepo) {
        this.weatherRepo = weatherRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public Weather getWeather(){
        RestTemplate restTemplate = new RestTemplate();

        Weather weaterdetails = restTemplate.getForObject(
                "https://www.metaweather.com/api/location/523920/", Weather.class);

        ConsolidatedWeather consolidatedWeather = weaterdetails.getConsolidatedWeather().get(0);

        return weaterdetails;
    }


    @EventListener(ApplicationReadyEvent.class)
    @Scheduled(cron = "0 0 * * * *")
    public void saveWeather(){
        ConsolidatedWeather consolidatedWeather = getWeather().getConsolidatedWeather().get(0);

        WeaterDetails weaterDetails = new WeaterDetails(
                getWeather().getTitle(),
                consolidatedWeather.getWeatherStateName(),
                consolidatedWeather.getWindDirectionCompass(),
                consolidatedWeather.getMinTemp().toString(),
                consolidatedWeather.getMaxTemp().toString(),
                consolidatedWeather.getTheTemp().toString(),
                consolidatedWeather.getAirPressure().toString(),
                consolidatedWeather.getPredictability()
        );
        weatherRepo.save(weaterDetails);
    }

    public WeatherService() {
    }
}

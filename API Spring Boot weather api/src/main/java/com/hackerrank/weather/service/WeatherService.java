package com.hackerrank.weather.service;

import java.util.List;
import java.util.Optional;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.repository.WeatherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class WeatherService {
  @Autowired
  WeatherRepository weatherRepository;

  // Create
  public Weather createWeather(Weather weather) {
    return weatherRepository.save(weather);
  }

  // Read
  public List<Weather> getAllWeather() {
    return weatherRepository.findAll();
  }

  // Ready by id
  public Optional<Weather> getWeatherById(Integer id) {
    return weatherRepository.findById(id);
  }

  // Delete by id
  public void deleteWeatherById(Integer id) {
    weatherRepository.deleteById(id);
  }



}

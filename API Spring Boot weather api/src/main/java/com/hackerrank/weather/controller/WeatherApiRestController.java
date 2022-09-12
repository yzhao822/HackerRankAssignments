package com.hackerrank.weather.controller;

import java.util.List;
import java.util.Optional;

import com.hackerrank.weather.model.Weather;
import com.hackerrank.weather.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherApiRestController {

  @Autowired
  WeatherService weatherService;

  @PostMapping
  @ResponseBody
  public ResponseEntity<Weather> createWeather(@RequestBody Weather weather) {
    Weather _weather = weatherService.createWeather(weather);
    return new ResponseEntity<>(_weather, HttpStatus.CREATED);
  }

  @GetMapping
  @ResponseBody
  public ResponseEntity<List<Weather>> getAllWeather() {
    List<Weather> weatherList = weatherService.getAllWeather();
    return new ResponseEntity<>(weatherList, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  @ResponseBody
  public ResponseEntity<Weather> getWeatherById(@PathVariable(value = "id") Integer id) {
    Optional<Weather> weather = weatherService.getWeatherById(id);
    if (weather.isPresent()) {
      return new ResponseEntity<>(weather.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/{id}")
  @ResponseBody
  public ResponseEntity<String> deleteWeatherById(@PathVariable(value="id") Integer id) {
    try {
      weatherService.deleteWeatherById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}

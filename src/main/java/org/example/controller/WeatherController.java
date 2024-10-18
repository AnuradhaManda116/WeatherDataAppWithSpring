package org.example.controller;

import org.example.model.WeatherData;
import org.example.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	private WeatherService weatherService;
	
	 @GetMapping("/{city}")
	 public WeatherData getWeather(@PathVariable String city) throws JsonProcessingException{
		 return this.weatherService.getWeatherOfCity(city);
	 }
	 
	 @PostMapping("/add")
	 public ResponseEntity<WeatherData> getWeathertwo(@RequestBody String city) throws JsonProcessingException {
	    	WeatherData weatherData = weatherService.getWeatherOfCity(city);
	        return ResponseEntity.ok(weatherData);
	 }
	 
     @DeleteMapping("/{id}")
     public String deleteCityById(@PathVariable String id){
         weatherService.deleteById(id);
         return "Data deleted...!";
     }

}

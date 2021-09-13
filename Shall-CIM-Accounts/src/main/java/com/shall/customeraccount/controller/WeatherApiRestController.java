package com.shall.customeraccount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shall.customeraccount.dto.WeatherDTO;
import com.shall.customeraccount.model.Weather;
import com.shall.customeraccount.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherApiRestController {

	@Autowired
	WeatherService weatherService;

	@RequestMapping(value = "/", produces = "application/json; charset=UTF-8", method = RequestMethod.POST)
	public ResponseEntity<Weather> saveWeatherRecord(@RequestBody WeatherDTO weatherRecord) {
		Weather result = weatherService.saveWeatherRecord(weatherRecord);
		return ResponseEntity.ok(result);
	}

	

	@RequestMapping(value = "/", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<List<WeatherDTO>> getWeatherRecords(@RequestParam(required = false) String date,
			@RequestParam(required = false) String city, @RequestParam(required = false) String sort) {
		List<WeatherDTO> result = weatherService.findAllWeatherRecords(date, city, sort);
		return ResponseEntity.ok(result);
	}
	
	
	@RequestMapping(value = "/{id}", produces = "application/json; charset=UTF-8", method = RequestMethod.GET)
	public ResponseEntity<WeatherDTO> getWeatherById(@PathVariable String id) {
		WeatherDTO result = weatherService.findById(id);
		return ResponseEntity.ok(result);
	}

}

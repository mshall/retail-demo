package com.shall.customeraccount.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shall.customeraccount.dto.WeatherDTO;
import com.shall.customeraccount.model.Weather;
import com.shall.customeraccount.repository.WeatherRepository;
import com.shall.util.Utils;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository weatherRepository;

	private Utils utils = new Utils();

	public List<WeatherDTO> findAllWeatherRecords(String date, String city, String sort) {
		if (date != null && !date.isEmpty()) {
			Date recordDate;
			try {
				recordDate = new SimpleDateFormat("YYYY-MM-DD").parse(date);
				List<Weather> weatherDBRecords = weatherRepository.findByWeatherDate(recordDate);
				List<WeatherDTO> weatherRecords = mapEntityListToDTOList(weatherDBRecords);
				return weatherRecords;
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (city != null && !city.isEmpty()) {
			List<String> cities = Arrays.asList(city.split(","));
			if (sort != null && !sort.isEmpty()) {
				if (sort.equalsIgnoreCase("date")) {
					List<Weather> weatherList = weatherRepository.findByCityInOrderByWeatherDateAsc(cities);
					// Perform the mapping
					List<WeatherDTO> weatherDTOList = mapEntityListToDTOList(weatherList);
					return weatherDTOList;
				} else if (sort.equalsIgnoreCase("-date")) {
					List<Weather> weatherList = weatherRepository.findByCityInOrderByWeatherDateDesc(cities);
					// Perform the mapping
					List<WeatherDTO> weatherDTOList = mapEntityListToDTOList(weatherList);
					return weatherDTOList;
				}
			} else {
				List<Weather> weatherList = weatherRepository.findByCityIn(cities);
				// Perform the mapping
				List<WeatherDTO> weatherDTOList = mapEntityListToDTOList(weatherList);
				return weatherDTOList;
			}

		}

		List<Weather> weatherDBRecords = weatherRepository.findAllByOrderByIdAsc();
		return mapEntityListToDTOList(weatherDBRecords);
	}

	
	public WeatherDTO findById(String id){
		Weather weatherDBRecord = weatherRepository.findOne(Integer.parseInt(id));
		return mapEntityToDTO(weatherDBRecord);
	}
	public List<WeatherDTO> mapEntityListToDTOList(List<Weather> weatherList) {
		List<WeatherDTO> weatherDTOList = new ArrayList<>();
		for (Weather weather : weatherList) {
			WeatherDTO weatherRecord = new WeatherDTO();
			weatherRecord.setId(weather.getId());
			weatherRecord.setCity(weather.getCity());
			weatherRecord.setDate(weather.getWeatherDate());
			weatherRecord.setLat(weather.getLat());
			weatherRecord.setLon(weather.getLon());
			weatherRecord.setState(weather.getState());
			List<Double> outcome = convertStringIntoList(weather.getTemperatures());
			weatherRecord.setTemperatures(outcome);
			weatherDTOList.add(weatherRecord);
		}
		return weatherDTOList;

	}
	
	public WeatherDTO mapEntityToDTO(Weather weather) {
			WeatherDTO weatherRecord = new WeatherDTO();
			weatherRecord.setId(weather.getId());
			weatherRecord.setCity(weather.getCity());
			weatherRecord.setDate(weather.getWeatherDate());
			weatherRecord.setLat(weather.getLat());
			weatherRecord.setLon(weather.getLon());
			weatherRecord.setState(weather.getState());
			List<Double> outcome = convertStringIntoList(weather.getTemperatures());
			weatherRecord.setTemperatures(outcome);
		
		return weatherRecord;

	}

	public List<Double> convertStringIntoList(String listString) {
		return DoubleStream.of(Arrays.stream(listString.split(",")).mapToDouble(Double::parseDouble).toArray()).boxed()
				.collect(Collectors.toList());
	}

	public Weather saveWeatherRecord(WeatherDTO weatherRecord) {
		Weather weather = new Weather();
		// weather.setId(1);
		weather.setCity(weatherRecord.getCity().toLowerCase());
		weather.setWeatherDate(weatherRecord.getDate());
		weather.setLat(weatherRecord.getLat());
		weather.setLon(weatherRecord.getLon());
		weather.setState(weatherRecord.getState());
		String tempString = weatherRecord.getTemperatures().stream().map(doubleValue -> String.valueOf(doubleValue))
				.collect(Collectors.joining(","));
		weather.setTemperatures(tempString);
		Weather savedWeather = weatherRepository.save(weather);
		return savedWeather;
	}
}

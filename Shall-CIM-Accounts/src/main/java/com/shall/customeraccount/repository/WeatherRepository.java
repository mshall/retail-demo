package com.shall.customeraccount.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shall.customeraccount.model.Weather;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {
	List<Weather> findAllByOrderByIdAsc();

	List<Weather> findAllByOrderByIdDesc();

	List<Weather> findByCityIn(List<String> cities);

	List<Weather> findByWeatherDate(Date date);

	List<Weather> findByCityInOrderByWeatherDateDesc(List<String> cities);

	List<Weather> findByCityInOrderByWeatherDateAsc(List<String> cities);

	List<Weather> findById(String id);
}

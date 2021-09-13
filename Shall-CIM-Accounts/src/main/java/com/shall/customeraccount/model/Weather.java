package com.shall.customeraccount.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@ToString
@Getter
@Setter
public class Weather {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "weather_id")
	private Integer id;
	@Column(name = "weather_date")
	private Date weatherDate;

	private Float lat;
	private Float lon;
	private String city;
	private String state;

	//@ElementCollection(targetClass=Double.class)
	//@CollectionTable(name="WEATHER", joinColumns=@JoinColumn(name="weather_id"))
	
	private String temperatures ;

	public Weather(Integer id, Date weatherDate, Float lat, Float lon, String city, String state, String temperatures) {
		this.id = id;
		this.weatherDate = weatherDate;
		this.lat = lat;
		this.lon = lon;
		this.city = city;
		this.state = state;
		this.temperatures = temperatures;
	}

	public Weather(Date weatherDate, Float lat, Float lon, String city, String state, String temperatures) {
		this.weatherDate = weatherDate;
		this.lat = lat;
		this.lon = lon;
		this.city = city;
		this.state = state;
		this.temperatures = temperatures;
	}

	public Weather() {
	}

}

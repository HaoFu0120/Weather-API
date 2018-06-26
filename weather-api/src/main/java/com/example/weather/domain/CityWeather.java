package com.example.weather.domain;

import org.springframework.data.annotation.Id;

public class CityWeather {
	
	private String base;
	private Coordinates coordinates;
	private MainInfo mainInfo;
	private Place place;
	private int visibility;
	private Weather weather;
	private Wind wind;
	
	@Id
	private String id;
	
	@Override
	public String toString() {
		return "CityWeather [base=" + base + ", coordinates=" + coordinates + ", mainInfo=" + mainInfo + ", place="
				+ place + ", visibility=" + visibility + ", weather=" + weather + ", wind=" + wind + "]";
	}

	public String getBase() {
		return base;
	}
	
	public void setBase(String base) {
		this.base = base;
	}
	
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	public MainInfo getMainInfo() {
		return mainInfo;
	}
	public void setMainInfo(MainInfo mainInfo) {
		this.mainInfo = mainInfo;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public int getVisibility() {
		return visibility;
	}
	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}
	public Weather getWeather() {
		return weather;
	}
	public void setWeather(Weather weather) {
		this.weather = weather;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}

}

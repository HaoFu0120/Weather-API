package com.example.weather.domain;

public class MainInfo {
	
	private float temp;
	private float pressure;
	private int humidity;
	private float temp_min;
	private float temp_max;
	
	
	@Override
	public String toString() {
		return "MainInfo [temp=" + temp + ", pressure=" + pressure + ", humidity=" + humidity + ", temp_min=" + temp_min
				+ ", temp_max=" + temp_max + "]";
	}
	public float getTemp() {
		return temp;
	}
	public void setTemp(float temp) {
		this.temp = temp;
	}
	public int getHumidity() {
		return humidity;
	}
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	public float getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(float temp_min) {
		this.temp_min = temp_min;
	}
	public float getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(float temp_max) {
		this.temp_max = temp_max;
	}
	public float getPressure() {
		return pressure;
	}
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

}

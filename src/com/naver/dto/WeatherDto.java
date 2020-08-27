package com.naver.dto;

public class WeatherDto {
	private String temp;
	private int realfeel;
	private int precip;
	private int hum;
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public int getRealfeel() {
		return realfeel;
	}
	public void setRealfeel(int realfeel) {
		this.realfeel = realfeel;
	}
	public int getPrecip() {
		return precip;
	}
	public void setPrecip(int precip) {
		this.precip = precip;
	}
	public int getHum() {
		return hum;
	}
	public void setHum(int hum) {
		this.hum = hum;
	}
}

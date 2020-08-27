package com.naver.dao;

import java.util.ArrayList;

import com.naver.dto.WeatherDto;

public interface WeatherDao {
	
	public void insert(WeatherDto dto);
	
	public ArrayList<WeatherDto> select();
}

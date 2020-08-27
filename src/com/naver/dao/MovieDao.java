package com.naver.dao;

import java.util.ArrayList;

import com.naver.dto.MovieDto;

public interface MovieDao {

	// 데이터 넣고 
	public void insert(MovieDto dto);
	
	// ID로 검색하고
	public boolean select(String email);
	
	// 전체 데이터 가져오기
	public ArrayList<MovieDto> select();
	
	// Email 과 PW를 검색
	public MovieDto select(String email, String pw);
	
	// 점수 정보 업데이트
	public void update(MovieDto dto);
}
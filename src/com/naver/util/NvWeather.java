package com.naver.util;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.naver.dto.WeatherDto;

public class NvWeather {
	public static ArrayList<WeatherDto> movie() throws IOException {
		// Dto 를 전달 하는 리스트
		ArrayList<WeatherDto> list = new ArrayList<WeatherDto>();
		String url = "https://www.accuweather.com/ko/kr/busan/222888/hourly-weather-forecast/222888";
		
		// GET 요청을 보내고 Document 객체를 변수 doc에 저장하기
		Document doc = Jsoup.connect(url).get();
		
		// CSS 선택자를 사용해 링크 추출하기
		Elements menus = doc.select("div.hourly-card-nfl-header");
		
		// 제목 링크 가져오기
		// 반복문 적용하기
		for (Element menu : menus) {
			// 링크의 "title" 속성 값 추출하기
//			String title = menu.attr("title").trim();
			
			// 링크의 URL 추출하기 (절대경로)
			String nextUrl = menu.absUrl("href");
			
			// 링크 대상 페이지에 접근하기
			Document nextDoc = Jsoup.connect(nextUrl).get();
			
			// 상세 내용 추출하기
//			String content = nextDoc.select("div.poster > a > img").attr("src");
			
			// 크롤링
			// 날씨 온도
			String temp = nextDoc.select("body > div > div.two-column-page-content > div.page-column-1 > div.content-module > div.hourly-wrapper.content-module > div:nth-child(1) > div.accordion-item-header-container > div > div.temp.metric").text();
			// 실제 온도
//			Elements realfeel = nextDoc.select("body > div > div.two-column-page-content > div.page-column-1 > div.content-module > div.hourly-wrapper.content-module > div:nth-child(1) > div.accordion-item-header-container > div > span.real-feel");

			// 크롤링 해온 데이터들을 Dto에 담는다.
			WeatherDto dto = new WeatherDto();
			dto.setTemp(temp);
//			dto.setGam(gam);
//			dto.setBae(bae);
//			dto.setImg(content);
			// Dto 담은 데이터를 list 에 담는다
			list.add(dto);
		}
		return list;
	}
}

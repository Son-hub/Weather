package com.naver.util;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.naver.dto.MovieDto;

public class NvMovie {
	// 그냥 매소드 만들어 봤어요~
	public static ArrayList<MovieDto> movie() throws IOException {
		// Dto 를 전달 하는 리스트
		ArrayList<MovieDto> list = new ArrayList<MovieDto>();
		String url = "https://movie.naver.com/movie/sdb/rank/rmovie.nhn";
		// GET 요청을 보내고 Document 객체를 변수 doc에 저장하기
		Document doc = Jsoup.connect(url).get();
//		System.out.println("Title : 네이버 영화 크롤링한거");
		// CSS 선택자를 사용해 링크 추출하기
		Elements menus = doc.select("div.tit3 a");
		// 제목 링크 가져오기
		// 반복문 적용하기
		for (Element menu : menus) {
			// 링크의 "title" 속성 값 추출하기
			String title = menu.attr("title").trim();
			// 링크의 URL 추출하기 (절대경로)
			String nextUrl = menu.absUrl("href");
			// log
//			System.out.println(String.format("%s\n\t%s", title, nextUrl));
			// 링크 대상 페이지에 접근하기
			Document nextDoc = Jsoup.connect(nextUrl).get();
			// 상세 내용 추출하기
			String content = nextDoc.select("div.poster > a > img").attr("src");
//			System.out.println(content);
			// 감독
			// #content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(4) > p > a
			String gam = nextDoc.select("#content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(4) > p > a").text();
//			System.out.println(gam);
			// 배우
			// #content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(6) > p > a:nth-child(1)
			String bae = nextDoc.select("#content > div.article > div.mv_info_area > div.mv_info > dl > dd:nth-child(6) > p > a:nth-child(1)").text();
//			System.out.println(bae);
			// 크롤링 해온 데이터들을 Dto에 담는다.
			MovieDto dto = new MovieDto();
			dto.setJe(title);
			dto.setGam(gam);
			dto.setBae(bae);
			dto.setImg(content);
			// Dto 담은 데이터를 list 에 담는다
			list.add(dto);
		}
		return list;
	}

}

package com.naver.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.naver.dao.MovieDao;
import com.naver.dao.MovieDaoImpl;
import com.naver.dto.MovieDto;
import com.naver.util.NaverAPIConfing;
import com.naver.util.NvMovie;
import com.naver.util.NvSearchApi;

@WebServlet("/MovieServlet")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MovieServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// view 쪽에 정보를 출력 하면 끝!!
		
		// 크롤링 버전
//		ArrayList<MovieDto> list = NvMovie.movie();
		// 데이터 베이스 버전
		MovieDao dao = new MovieDaoImpl();
		ArrayList<MovieDto> list = dao.select();
		// MovieDto 를 Json 형태로 변환 시키는 작업을 해야 한다.
		// Gson 라이브러리를 활용 하면 쉽게 변환 시킬 수 있다.
		// 변환된 문자열을 아래에서 뿌린다.
		// 나오는 형태가 [{"title":"반도", "link":"http://", "img":"http://"}, ...]
		Gson gson = new Gson();
		String jsonData = gson.toJson(list);
		System.out.println(jsonData);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonData);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

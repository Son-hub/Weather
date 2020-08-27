package com.naver.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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

@WebServlet("/MovieServlet2")
public class MovieServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MovieServlet2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// view 쪽에 정보를 출력 하면 끝!!
		
		// 크롤링 버전
//		ArrayList<MovieDto> list = NvMovie.movie();
		// 데이터 베이스 버전
		MovieDao dao = new MovieDaoImpl();
		ArrayList<MovieDto> list = dao.select();
		for (MovieDto d : list) {
			System.out.println(d.getJe());
			System.out.println(d.getImg());
			System.out.println(d.getBae());
			System.out.println(d.getGam());
			System.out.println(d.getNum());
		}
		request.setAttribute("movieList", list);
		
		// 뷰로 보냄
		RequestDispatcher dis = request.getRequestDispatcher("movie2.jsp");
		dis.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

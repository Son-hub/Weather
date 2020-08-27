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

// 한번만

@WebServlet("/MovieDbServlet")
public class MovieDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MovieDbServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// view 쪽에 정보를 출력 하면 끝!!
		ArrayList<MovieDto> list = NvMovie.movie();
		MovieDao dao = new MovieDaoImpl();
		for (MovieDto t : list) {
			dao.insert(t);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
import com.naver.dao.HugiDao;
import com.naver.dao.HugiDaoImpl;
import com.naver.dao.MovieDao;
import com.naver.dao.MovieDaoImpl;
import com.naver.dto.HugiPrintDto;
import com.naver.dto.MovieDto;
import com.naver.util.NaverAPIConfing;
import com.naver.util.NvMovie;
import com.naver.util.NvSearchApi;

@WebServlet("/HugiPrintServlet")
public class HugiPrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public HugiPrintServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 베이스 버전
		HugiDao dao = new HugiDaoImpl();
		ArrayList<HugiPrintDto> list = dao.select();
		for (HugiPrintDto d : list) {
			System.out.println(d.getNo());
			System.out.println(d.getJe());
			System.out.println(d.getTitle());
			System.out.println(d.getScore());
			System.out.println(d.getName());
		}
		request.setAttribute("hugiList", list);
		
		// 뷰로 보냄
		RequestDispatcher dis = request.getRequestDispatcher("hugi.jsp");
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

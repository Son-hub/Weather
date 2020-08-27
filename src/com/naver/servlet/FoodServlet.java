package com.naver.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.util.NaverAPIConfing;
import com.naver.util.NvSearchApi;
import com.naver.util.NvSearchFoodApi;

@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FoodServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// view(jsp, html)에서 넘어 오는 데이터 search 값을 받아준다
		// 한글 설정
		request.setCharacterEncoding("utf-8");
		String search = request.getParameter("search");
		System.out.println(">>>>>>>>>>>>>>>>>>>>> " + search);
		// 네이버API를 활용해서 정보를 가져온다(json 형태로 넘어옴)
		String jsonData = NvSearchFoodApi.search(search + " 맛집");
		// view 쪽에 정보를 출력 하면 끝!!
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

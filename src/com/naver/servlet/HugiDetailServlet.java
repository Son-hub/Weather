package com.naver.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.naver.dao.HugiDao;
import com.naver.dao.HugiDaoImpl;
import com.naver.dao.MemberDao;
import com.naver.dao.MemberDaoImpl;
import com.naver.dto.HugiDto;
import com.naver.dto.HugiPrintDto;
import com.naver.dto.MemberDto;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/HugiDetailServlet")
public class HugiDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HugiDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		// 넘어온 데이터를 받고
		String mv_num = request.getParameter("mv_num");
		// 잘넘어오는지 체크
		System.out.println(mv_num);
		// 데이터를 DB에 넣고

		HugiDao dao = new HugiDaoImpl();
		HugiPrintDto dto = dao.select(mv_num);
		System.out.println(dto.getJe());
		System.out.println(dto.getContent());
		
		Gson gson = new Gson();
		String jsonData = gson.toJson(dto);
		System.out.println(jsonData);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(jsonData);
		
//		HugiDto dto = new HugiDto();
		// ajax 에서 받을 메세지
//		response.getWriter().append("detail ok");
		// 페이지로 이동
//		response.sendRedirect("login.nhn");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

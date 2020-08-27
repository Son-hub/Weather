package com.naver.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.dao.HugiDao;
import com.naver.dao.HugiDaoImpl;
import com.naver.dao.MemberDao;
import com.naver.dao.MemberDaoImpl;
import com.naver.dto.HugiDto;
import com.naver.dto.MemberDto;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/HugiServlet")
public class HugiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HugiServlet() {
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
		String mb_num = request.getParameter("mb_num");
		String h_tit = request.getParameter("h_tit");
		String hugi = request.getParameter("hugi");
		// 잘넘어오는지 체크
		System.out.println(mv_num);
		System.out.println(mb_num);
		System.out.println(h_tit);
		System.out.println(hugi);
		// 데이터를 DB에 넣고
		HugiDto dto = new HugiDto();
//		Integer.parseInt(mv_num);
		dto.setMv_num(Integer.parseInt(mv_num));
		dto.setMb_num(Integer.parseInt(mb_num));
		dto.setTitle(h_tit);
		dto.setContent(hugi);
		HugiDao dao = new HugiDaoImpl();
		dao.insert(dto);
		
		// ajax 에서 받을 메세지
		response.getWriter().append("ok");
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

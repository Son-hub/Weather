package com.naver.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.naver.dao.MemberDao;
import com.naver.dao.MemberDaoImpl;
import com.naver.dto.MemberDto;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("login ").append(request.getContextPath());
//		request.setAttribute("email", "a@a.com");  // String email = "a@a.com";
//		response.sendRedirect("login.jsp");
//		RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
//		dis.forward(request, response);
		// 한글 처리
		request.setCharacterEncoding("utf-8");
		// 넘어온 데이터를 받고
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		// 잘넘어오는지 체크
		System.out.println(name);
		System.out.println(email);
		System.out.println(pw);
		System.out.println(phone1);
		System.out.println(phone2);
		// 데이터를 DB에 넣고
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setEmail(email);
		dto.setPw(pw);
		dto.setTel(phone1 + phone2);
		MemberDao dao = new MemberDaoImpl();
		dao.insert(dto);
		// 로그인 페이지로 이동
		response.sendRedirect("login.nhn");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

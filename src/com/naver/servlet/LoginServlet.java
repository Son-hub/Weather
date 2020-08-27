package com.naver.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.naver.dao.MemberDao;
import com.naver.dao.MemberDaoImpl;
import com.naver.dto.MemberDto;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		System.out.println(email);
		System.out.println(pw);
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html charset='utf-8'");
		// 디비 연결하고
		// 이멜과 패스를 확인해서
		// 있으면 있다 없으면 없다
		MemberDao dao = new MemberDaoImpl(); 
		MemberDto dto = dao.select(email, pw);
		if (dto != null) {
			System.out.println("있다");
			HttpSession session = request.getSession();
			session.setAttribute("member", dto);
		} else {
			System.out.println("없다");
		}
		response.sendRedirect("logincheck.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.naver.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HelloServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 여기 매소드만 신경 쓰면 된다.
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("email");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("헬로 월드~ (서버 시스템 콘솔창에 나오는 메세지)");
		out.println("당신이 입력한 이메일을 전달해줍니다<br>" + email);
		out.println("<br>헬로 월드~ (클라이언트 브라우저 화면에 나오는 메세지)");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

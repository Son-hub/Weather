<%@page import="com.naver.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
MemberDto dto = (MemberDto)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
<% if (dto == null) { %>
	alert("이메일과 패스워드를 확인하세요");
	location.href="login.nhn";
<% } else { %>
	alert("안녕하세요~ <%=dto.getName()%> 님!!");
	location.href="main.nhn";
<% } %>
</script>
</body>
</html>
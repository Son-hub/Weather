<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.naver.dto.MovieDto"%>
<%@page import="java.util.ArrayList"%>
    
<%@ include file="top.jsp" %>

<%
ArrayList<MovieDto> list = (ArrayList<MovieDto>)request.getAttribute("movieList");
if (dto == null) {
	response.sendRedirect("login.nhn");
	return;
}
%>

<div class="container">

<h3>영화 랭킹 출력</h3>
<% for (MovieDto mv : list) { %>
<img alt="" src="<%=mv.getImg() %>"><br>
<button type="button" class="btn btn-success" onclick="send('<%=mv.getJe()%>')" >후기작성</button><br>
<% } %>
</div>
<script>
function send(je) {
	alert(je);
	alert("<%=dto.getName() %>");
}
</script>

</body>
</html>
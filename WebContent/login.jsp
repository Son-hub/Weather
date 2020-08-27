<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="top.jsp" %>

<div class="container">
<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">로그인</h4>
	<p class="text-center">로그인을 하세요</p>
	<form action="loginok.nhn" method="post">

    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <input name="email" class="form-control" placeholder="Email address" type="email" value="">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input name="pw" class="form-control" placeholder="password" type="password">
     
    </div> <!-- form-group// -->                                      
    <div class="form-group">
        <button type="submit" class="btn btn-primary btn-block"> Login  </button>
    </div> <!-- form-group// -->      
    <p class="text-center">아이디가 없으신가요? <a href="join.nhn">Sign up</a> </p>                                                                 
</form>
</article>
</div> <!-- card.// -->

</div> 
<!--container end.//-->

</body>
</html>
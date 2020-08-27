<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<div class="container">
<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">회원가입</h4>
	<p class="text-center">회원가입을 하세요</p>
	<form action="joinok.nhn" method="post">
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="name" class="form-control" placeholder="name" type="text">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <input name="email"  id="email" class="form-control" placeholder="Email address" type="email">

    </div> <!-- form-group// -->
    <div class="form-group input-group">
       	<div class="alert alert-success" id="email-success">email 사용이 가능합니다.</div>
    	<div class="alert alert-danger" id="email-danger">이미 가입된 Email이 있습니다.</div>
    </div>
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
		</div>
		<select id="phone1" name="phone1" class="custom-select" style="max-width: 120px;">
		    <option value="010" selected>010</option>
		    <option value="011">011</option>
		    <option value="017">017</option>
		    <option value="016">016</option>
            <option value="019">019</option>
		</select>
    	<input id="phone2" name="phone2" class="form-control" placeholder="Phone number" type="text">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input name="pw" id="pw" class="form-control" placeholder="Create password" type="password">
        
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-lock"></i> </span>
		</div>
        <input id="repw" class="form-control" placeholder="Repeat password" type="password">
    </div> <!-- form-group// -->     

    <div class="form-group input-group">
    	<div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div>
    	<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>
    </div> <!-- form-group// --> 
                                     
    <div class="form-group">
        <button type="submit" id="submit" class="btn btn-primary btn-block"> 회원 가입  </button>
    </div> <!-- form-group// -->      
    <p class="text-center">아이디가 있으신가요? <a href="login.nhn">Log In</a> </p>                                                                 
</form>
</article>
</div> <!-- card.// -->

</div> 
<!--container end.//-->
<script type="text/javascript">

    $(function(){
        $("#alert-success").hide();
        $("#alert-danger").hide();
        $("#repw").keyup(function(){
//         	console.log("눌렀다");
            var pwd1=$("#pw").val();
            var pwd2=$("#repw").val();
            console.log("pw: " + pwd1);
            console.log("repw: "+ pwd2);
            
            if(pwd1 != "" || pwd2 != ""){
                if(pwd1 == pwd2){
                    $("#alert-success").show();
                    $("#alert-danger").hide();
                    $("#submit").removeAttr("disabled");
                }else{
                    $("#alert-success").hide();
                    $("#alert-danger").show();
                    $("#submit").attr("disabled", "disabled");
                }    
            } 
        });
    });
$(document).ready(function(){    
    $("#email-success").hide();
    $("#email-danger").hide();
    $("#email").blur(function(){
        var email = $("#email").val();
        console.log(email + ' 이메일 체크!!');
        $.post("emailck.nhn",
        	    {
        	      email: email
        	    },
        	    function(data,status){
        	    	if (data.trim() == "ok") {
        	    		$("#email-success").hide();
       	    		 	$("#email-danger").show();
//          	    		alert("이메일이 있습니다");	
        	    	} else {
        	    		$("#email-danger").hide();
        	    		$("#email-success").show();

//          	    		alert("가입이 가능한 메일입니다.");	
        	    	}
        	      
       	});
    });
    $("#phone1").blur(function(){
        $("#email-success").hide();
        $("#email-danger").hide();
    });
    $("#phone2").blur(function(){
        $("#email-success").hide();
        $("#email-danger").hide();
    });
});
</script>
</body>
</html>
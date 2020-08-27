<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="top.jsp" %>
<%
	if (dto == null) {
		response.sendRedirect("login.nhn");
		return;
	}
%>
<div class="container">

<h3>영화 랭킹 출력</h3>
<!-- <button type="button" class="btn btn-success" onclick="modal_show('영화제목')">후기작성</button><br> -->
<div id="result"></div>


 <!-- The Modal -->
  <div class="modal fade" id="myModal">
    <div class="modal-dialog">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">영화 후기 작성</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
       
            <div class="form-group">
              <label for="m_tit">영화제목:</label>
              <input type="text" class="form-control" id="m_tit" placeholder="영화제목" name="m_tit" disabled>
              <input type="hidden" id="mv_num" value="">
            </div>
            <div class="form-group">
              <label for="name">작성자:</label>
              <input type="text" class="form-control" id="name" placeholder="작성자" name="name" disabled>
              <input type="hidden" id="mb_num" value="">
            </div>
           <div class="form-group">
              <label for="h_tit">후기제목:</label>
              <input type="text" class="form-control" id="h_tit" placeholder="후기제목" name="h_tit">
            </div>
    
            <div class="form-group">
              <label for="hugi">후기 작성:</label>
              <textarea class="form-control" rows="5" id="hugi" name="hugi"></textarea>
            </div>
            

        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="submit" class="btn btn-primary" id="okBtn">작성완료</button>
          <button type="button" class="btn btn-danger" id="close_modal">Close</button>
        </div>
        
      </div>
	</div>
	</div>
 <!-- The Modal -->
</div>  
<script>
function modal_show (num) {
    $("#myModal").modal("show");
    // 사용자에게 보여주는 값 셋팅
	var je = $("#mv" + num).val();
	$("#m_tit").val(je); // 영화 제목
	$("#name").val('<%=dto.getName() %>');  // 작성자
	
	// 데이터 넘길 때 값 세팅
	$("#mv_num").val(num);   // 영화 번호
	$("#mb_num").val(<%=dto.getNum() %>);  // 유저 번호
//     alert(je);
}

$(document).ready(function(){
    $("#close_modal").click(function() {
        $("#myModal").modal("hide");
    });
    
    $("#okBtn").click(function() {
//         alert("전송 합시다.");
        var m_tit = $("#mv_num").val();  // 영화 제목
        var name = $("#mb_num").val();   // 작성자
        var h_tit = $("#h_tit").val();  // 후기 제목
        var hugi = $("#hugi").val();   // 후기 내용
        
        console.log(m_tit);
        console.log(name);
        console.log(h_tit);
        console.log(hugi);
        
        $.post("hugiok.nhn",
        {
        	mv_num:	m_tit,
        	mb_num:	name,
        	h_tit:	h_tit,
        	hugi:	hugi
        }, function(data, status){
        	if (data.trim() == "ok") {
        		alert("후기가 저장 되었습니다.");
        		location.reload();   // 페이지 새로고침
        	} else {
        		alert("저장에 실패 했습니다.\n관리자에게 문의");
        	}
        });
    });
	
    $.get("movieok.nhn",
    function(data, status){
    	var html = "";
//     	console.log(data);
//     	console.log(data.items);
    	$.each(data, function(key, field){
//     		console.log(key);	
//     		console.log(field);	
    		html += "<img src='" + field.img + "'><br>";
    		html += field.je + "<br>";
    		html += field.gam + "<br>";
    		html += field.bae + "<br>";
    		html += "<input type='hidden' id='mv" + field.num  + "' value='" + field.je + "'>";
//     		html += '<button type="button" class="btn btn-success" onclick="modal_show(\'' + field.je + '\')">후기작성</button><br>>';
    		html += '<button type="button" class="btn btn-success" onclick="modal_show(' + field.num + ')">후기작성</button><br>';
          });
		$("#result").html(html);
    });
});
</script>
</body>
</html>
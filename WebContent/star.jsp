<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="top.jsp" %>

<!-- bar-rating -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-bar-rating/1.2.2/themes/fontawesome-stars.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-bar-rating/1.2.2/jquery.barrating.min.js"></script>

<div class="container">					

<div class="br-wrapper br-fractional">
<select id="example">
	<option value="1">1</option>
	<option value="2">2</option>
	<option value="3">3</option>
	<option value="4">4</option>
	<option value="5">5</option>
</select>
</div>	
<script type="text/javascript">
   $(function() {
// 	   $('#example').barrating('set', 2);
	   
	   $('#example').barrating({
			theme: 'fontawesome-stars'
			, initialRating: 1, readonly: true
// 			, onSelect: function(value, text, event){
// 				console.log(value);
// 			}
		});
   });
</script>

</div>								

<script>
$(document).ready(function(){
	var search = $("#search").val();
	$("#result").html("여기에 찍히나: " + search);
	console.log(search);
//     $.get("movieok.nhn",
//     function(data, status){
//     	var html = "";
//     	console.log(data);
// //     	console.log(data.items);
//     	$.each(data, function(key, field){
//     		console.log(key);	
//     		console.log(field);	
// //     		html += "<a href='" + field.link + "' target='_blank'>"
// //     		html += "<img src='" + field.img + "'></a><br>";
// //     		html += field.je + "<br>";
// //     		html += field.gam + "<br>";
// //     		html += field.bae + "<br>";
//           });
// 		$("#result").html(html);
//     });
});
</script>
</body>
</html>
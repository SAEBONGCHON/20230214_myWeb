<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	<section>
	<h1>회원가입</h1>
			<form action="<%=request.getContextPath()%>/enroll" method="post">
			id:<input type="text" name="id"> 
			<br>
			pw:<input type="password" name="passwd">
			<br>
			name:<input type="text" name="name">
			<br>
			email:<input type="text" name="email">
			<br>
			<button type="submit">회원가입</button>
		</form>
	</section>
	
	<script>
	$("#dupId").click(checkDupId);
	function checkDupId(){
		$.ajax({
			url:"<%=request.getContextPath()%>/dupid.lo"
			, type: "post"
			, async:false
			, data: {id: $("input").first().val()}
			, success: function(result){
				console.log(result);
				if(result == 1){
					$("input").first().next().next();
				}
			}
			, error: function(request, status, error){
				alert(request.status);
			}
		});
	}
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kh 로그인</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	<section>
		<!--    private String id;
		   		private String passwd; -->
		<form action="login" method="post">
			id:<input type="text" name="id"> 
			<br>
			pw:<input type="password" name="passwd">
			<br>
			<button type="submit">로그인하기</button>
			<button type="button" class="btn enroll">회원가입</button>
		</form>
	</section>
	<%--1. 회원가입("/enroll") - get enroll.jsp , post 회원가입 DB다녀와서 ("/")이동
 *	회원가입화면 - 회원가입 (/enroll post) 버튼  --%>
	<script>
		$(".btn.enroll").on("click", handlerClickBtnEnroll)
		function handlerClickBtnEnroll(){
			console.log("btnEnroll 버튼 눌림");
			location.href="<%=request.getContextPath()%>/enroll";
		}
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>
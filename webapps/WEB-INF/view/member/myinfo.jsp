<%@page import="kh.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
<!-- 내정보보기
보여야할 정보(id, name, email, pw도 감춰진 상태로 보여질 수 
있으니까 컨트롤러에서 전달해줬어야한ㄴ다.) -->
<h1>내정보보기</h1>
<h4>El request attribute</h4>
		<c:if test="${not empty myinfo }">
			<div>
				id : ${myinfo.id }
				<br>
				name : ${myinfo.name }
				<br>
				name : ${myinfo.email }
				<br>	
			</div>
		</c:if>
		<hr>
		<h4>El session attribute</h4>
		<c:if test="${not empty myinfo }">
			<div>
				id : ${myinfo.id }
				<br>
				name : ${myinfo.name }
				<br>
				name : ${myinfo.email }
				<br>
			</div>
		</c:if>
<hr>
<h4>JSP request attribute</h4>



<%
	Object obj = request.getAttribute("myinfo");
	MemberVo vo = null;
	if(obj == null){
%>			
		
			<h4>로그인 되지 않았습니다. 정보가 없습니다.</h4>
			<a href="<%=request.getContextPath()%>/login">로그인페이지이동</a>		
<%			
		} else {
			if(obj instanceof MemberVo){
				vo = (MemberVo)obj;
			}
			if(vo == null){
				//로그아웃 상태					
%>			
			<h4>로그인 되지 않았습니다. 정보가 없습니다.</h4>
			<a href="<%=request.getContextPath()%>/login">로그인페이지이동</a>
<%
			}
	}
%>
			

</body>
</html>
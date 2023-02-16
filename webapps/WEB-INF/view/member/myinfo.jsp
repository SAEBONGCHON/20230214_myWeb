<%@page import="kh.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			id : <%=vo.getId() %>
			<br>
			pw : <%=vo.getPasswd() %>
			<br>
			name : <%=vo.getName() %>
			<br>
			이전페이지
			<a href="<%=request.getContextPath()%>/login">로그인페이지이동</a>

</body>
</html>
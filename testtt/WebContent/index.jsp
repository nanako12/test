<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "member.model.vo.*" %>
<% Member m = (Member)session.getAttribute("user"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인 페이지</title>
</head>
<body>

<style>
	#back1{
	width : 500px;
	height : 400px;
	background-color: #FFEAEA;
	padding-top: 60px;
	}
	fieldset{
		
	}
</style>

<%if(m==null) {%>
<center>
<div id="back1">
<fieldset style="width:300px; height:300px;">
	<legend>로그인</legend>
<form action="login" method="post" style="display:inline;">
<br><br>
ID : <input type="text" placeholder="ID를 입력하세요" name ="userId" /><br><br>
PW : <input type="password" placeholder="PW를 입력하세요" name = "userPwd"  /><br><br><hr>
<input type="submit" value="로그인"/><br><br>
</form>
<a href="/views/member/joinus.html">회원가입</a>
<a href="">ID 찾기</a> /
<a href="">PW 찾기</a>
</fieldset>
</div>
</center>
<%}else{ %>
	[<%=m.getUserName() %>]님 환영 합니다.<br>
	<a href="">마이페이지</a><br>
	<a href="/logout">로그아웃</a><br>
	<a href="">회원탈퇴</a><br>
<%} %>
</body>
</html>
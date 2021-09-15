<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>

<%@ page import="Pack.Person" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test</h1>
	<% response.setContentType("text/html; charset=UTF-8");%>
	<% request.setCharacterEncoding("UTF-8");%>
	<form method = post action="insert.jsp">
		<input type="text" name="name" value="È£¶ûÀÌ"><br>
		<input type="text" name="age" value="11"><br>
		<input type="submit" value="Submit">
	</form>
</body>
</html>
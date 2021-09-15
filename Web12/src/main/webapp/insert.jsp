<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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

	<% response.setContentType("text/html; charset=UTF-8");%>
	<% request.setCharacterEncoding("UTF-8");%>
	<jsp:useBean id="recv" class="Pack.Person" scope="page" />
	<jsp:setProperty name="recv" property="*"/>
	
	<jsp:getProperty name="recv" property="name"/>
	<jsp:getProperty name="recv" property="age"/>
	
	
	<% 
	
		String  jdbcDriver = "com.mysql.jdbc.Driver";
		//¿©±â ¹Ù²ãÁà¾ßÇÔ
		String dbUr1 = "jdbc:mysql://220.119.22.165:8899/db01?useSSL=false";
		String username = "test01";
		String password = "1234";
		
		String usrName = request.getParameter("name");
		String usrAge = request.getParameter("age");
			
		Connection con = null;
		java.sql.Statement st = null;
		Class.forName(jdbcDriver);//.newInstance();
		con=DriverManager.getConnection(dbUr1, username, password);
		st = con.createStatement();
		
		//System.out.println(usrName);
		st.executeUpdate("insert into table01 values('"+usrName+"','"+usrAge+"')");
		
		//System.out.println("µ¥ÀÌÅÍ »ğÀÔ ¿Ï·á");
		con.close();
		
		response.sendRedirect("index.jsp");
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>List Page</h4>
	Welcome:<shiro:principal></shiro:principal><br/>
	<shiro:hasRole name="admin">	
		<a href="admin.jsp">Admin Page</a><br/>
	</shiro:hasRole>
	<shiro:hasRole name="user">
		<a href="User.jsp">User Page</a><br/>
	</shiro:hasRole>
	<a href="shiro/logout">Logout</a><br/>
	<a href="shiro/testShiroAnnotation">Test ShiroAnnotation</a>
</body>
</html>
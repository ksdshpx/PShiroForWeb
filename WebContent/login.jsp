<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Login Page</h4>
	<form action="shiro/login" method="post">
		用户名:<input type="text" name="username"/><br/>
		密    码:<input type="password" name="password"/><br/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>
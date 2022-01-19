<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Love Calulator</h1>
	<hr />
	<h2>Love Calculator Pridicts : </h2><br/>
	${user.userName} and ${user.crushName} are 
	<br/>
	${user.result}
	
	<br/>
<!-- 	<a href="/sprin-love-calculator/sendEmail">Send Result to Your Email</a>
 -->
 
 <a href="<c:url value="/sendEmail"/>">Send Result to Your Email</a>
 
 </body>
</html>
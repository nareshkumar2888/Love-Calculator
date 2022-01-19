<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@page isELIgnored="false" %>	
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>HI ${user.userName}</h2>
<h3>Send Result To Your Email</h3>
<form:form action="process-email" method="get" modelAttribute="emailDTO">
<label>Enter Your Email </label>
<form:input path="userEmail"/>
<input type="submit" value="Send">
</form:form>
</body>
</html>
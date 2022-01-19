<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Registration Successful</h1>
	<h2>the details entered by you are :</h2>

	User : ${userReg.name}
	<br /> UserName : ${userReg.userName}
	<br /> password : ${userReg.password}
	<br /> Country Name : ${userReg.countryName}
	<br /> Hobbies :
	<c:forEach var="temp" items="${userReg.hobbies}">
		${temp}

	</c:forEach>
	<br /> Gender : ${userReg.gender}
	<br />Email: ${userReg.communicationDTO.email}
	<br/>Phone: ${userReg.communicationDTO.phone}

</body>
</html>
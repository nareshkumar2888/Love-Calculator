<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">
	function validateUserName() {
		var userName = document.getElementById("yn").value;
		if (userName.length < 1) {

			alert("your name should have atleast one char");
			
			return false;
		} else {
			return true;
		}

	}
</script>

<style type="text/css">
.error{
	color:red;
	position:fixed;
	text-align:left;
	margin-left:30px;
}

</style>
</head>
<body>
	<h1 align="center">Love Calculator</h1>

	<form:form action="process-homepage" method="get"
		modelAttribute="user">
		<div align="center">
			<p>
				<label for="yn">Your Name :</label>
				<form:input id="yn" path="userName" />
				<form:errors path="userName" cssClass="error"/>
			</p>

			<p>
				<label for="cn">Crush Name :</label>
				<form:input id="cn" path="crushName" />
				<form:errors path="crushName" cssClass="error"/>
			</p>
			<p><form:checkbox path="termAndCondition" id="check"/>
			<label>I am agreeing that this is for fun</label>
			<form:errors path="termAndCondition" cssClass="error" />
			</p>
			<input type="submit" value="calculate">
		</div>
	</form:form>


</body>
</html>
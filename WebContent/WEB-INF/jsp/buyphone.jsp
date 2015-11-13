<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
input[type="submit"] {
	background-color: #FF8000;
	color: white;
	width: 100px;
	height: 30px;
}

table {
	background-color: #2EFE2E;
	margin-top: 100px;
	width: 30%;
	text-align: center;
	padding-bottom: 10px;
	padding-top: 20px;
	font-family: "Tahoma";
	color: #FF8000;
	border-radius: 25px;
}

h1 {
	font-size: 40px;
}

input[type="text"], input[type="password"] {
	background-color: #ffff99;
	height: 25px;
}

label {
	font-weight: bold;
}
</style>
</head>
<body style="background-color: #CEF6F5">
	<form:form method="POST" action="/TestPhoneShop/test" modelAttribute="order">
		<table align="center">
			<form:input type="hidden" path = "product_id" value="${order.product_id}" />
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>				
				<td><form:label path="password">Password</form:label></td>
				<td><form:input type="password" path="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Confirm" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
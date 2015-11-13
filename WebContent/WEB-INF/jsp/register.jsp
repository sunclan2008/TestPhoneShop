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
	height: 300px;
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
	<form:form method="POST" action="/TestPhoneShop/register">
		<table align="center">
			<tr>
				<td colspan="2"><h1>Register</h1></td>
			</tr>
			<tr>
				<td><form:label path="first_name">First Name</form:label></td>
				<td><form:input path="first_name" /></td>
			</tr>
			<tr>
				<td><form:label path="last_name">Last Name</form:label></td>
				<td><form:input path="last_name" /></td>
			</tr>
			<tr>
				<td><form:label path="username">Username</form:label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:input type="password" path="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
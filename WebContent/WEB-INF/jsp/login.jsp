<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring MVC Form Login</title>
<style type="text/css">
input[type="submit"]
{
background-color: #FA58F4;
color: white;
width: 100px;
height: 30px;
}

table{
background-color: #2EFE2E;
margin-top: 100px;
width: 30%;
text-align: center;
padding-bottom: 10px;	
height: 300px;
font-family: "Tahoma";
color: white;
border-radius: 25px;
}
h1{
font-size: 40px;
}
input[type="text"],input[type="password"]{
	background-color: #ffff99;
	height: 25px;
}
label{
font-weight: bold;
}
</style>
</head>
<body style="background-color:#CEF6F5">
	
	<form:form method="POST" action="/TestPhoneShop/login">
		<table align="center">
		<tr><td colspan="2"><h1>LOGIN</h1></td></tr>
			<tr>
				<td><form:label style="color:#700" path="username">Username</form:label></td>
				<td><form:input path="username" type="text" /></td>
			</tr>
			<tr>
				<td><form:label style="color:#700" path="password">Password</form:label></td>
				<td><form:input type="password" path="password" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login" /></td>
				<td><a href="/TestPhoneShop/register">Register</a></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
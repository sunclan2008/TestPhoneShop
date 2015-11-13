<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	text-align: center;
	font-family: "Tahoma";
	color: #0404B4;
}

b {
	font-size: 30px;
	color: #FA58AC;
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
	<center>
		<br /> <br /> <br /> <b>Your Order</b><br /> <br /> <br /> <br />
		<table border="1">
			<tr>
				<th class="heading">Order ID</th>
				<th class="heading">Product Name</th>
				<th class="heading">Product brand</th>
				<th class="heading">Product price</th>
				<th class="heading">Delete Order</th>
			</tr>
			<c:forEach var="o" items="${order}">
				<tr>
					<td>${o.order_id}</td>
					<td>${o.product_name}</td>
					<td>${o.product_brand}</td>
					<td>${o.product_price}</td>
					<td><a href="/TestPhoneShop/order/del?id=${o.order_id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br /> <br /> <br /> <a href="/TestPhoneShop/shoppinghome">Shop</a>
		<a href="/TestPhoneShop/login">Logout</a>
	</center>
</body>
</html>
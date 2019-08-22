<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Here is the list of all smartphone available</h2>
<table style="width:100%">
  <tr>
    <th>ID</th>
    <th>Brand</th> 
    <th>Model</th>
    <th>Price</th>
  </tr>
  <tr>
    <td>${id}</td>
    <td>${brand}</td>
    <td>${model}</td>
    <td>${price}</td>
  </tr>
</body>
</html>
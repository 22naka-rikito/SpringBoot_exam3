<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果</title>
</head>
<body>
	<p>登録が完了しました</p>
	<table border="1">
		<tr>
			<th>product_id</th>
			<th>product_name</th>
			<th>price</th>
		</tr>
		<c:forEach var="product" items="${list}">
			<tr>
				<td>${product.productId}</td>
				<td>${product.productName}</td>
				<td>${product.price}</td>
			</tr>
		</c:forEach>
	</table>
		<a href="top">戻る</a>

</body>
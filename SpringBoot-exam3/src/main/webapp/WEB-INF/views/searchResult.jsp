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
	<p>検索結果</p>
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
<!-- 	<p> -->
<!-- 		product_id: -->
<%-- 		<c:if test="${not empty product.productId}"> --%>
<%-- 			${fn:escapeXml(product.productId)} --%>
<%-- 		</c:if> --%>
<!-- 	</p> -->
<!-- 	<p> -->
<!-- 		product_name: -->
<%-- 		<c:if test="${not empty product.productName}"> --%>
<%-- 			${fn:escapeXml(product.productName)} --%>
<%-- 		</c:if> --%>
<!-- 	</p> -->
<!-- 	<p> -->
<!-- 		price: -->
<%-- 		<c:if test="${not empty product.price}"> --%>
<%-- 			${fn:escapeXml(product.price)} --%>
<%-- 		</c:if> --%>
<!-- 	</p> -->
		<a href="top">戻る</a>

</body>
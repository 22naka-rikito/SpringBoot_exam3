<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果</title>
</head>
<body>
	<h1>削除対象のproduct_idを入力してください</h1>
	<c:if test="${not empty msg}">
		<fmt:message key="form.lbl.msg" />
	</c:if>
	<form:form action="updateResult" modelAttribute="update" method="post">
		<div>
			<p>
				<label><fmt:message key="form.lbl.product_id" /></label>
				<form:input path="productId" />
				<form:errors path="productId" cssStyle="color: red" />
			</p>
			<p>
				<label><fmt:message key="form.lbl.name" /></label>
				<form:input path="productName" />
				<form:errors path="productName" cssStyle="color: red" />
			</p>
			<p>
				<label><fmt:message key="form.lbl.price" /></label>
				<form:input path="price" />
				<form:errors path="price" cssStyle="color: red" />
			</p>
		</div>
		<form:button name="update">
			<fmt:message key="form.lbl.update" />
		</form:button>
	</form:form>
	<a href="top"><fmt:message key="form.lbl.back" /></a>

</body>
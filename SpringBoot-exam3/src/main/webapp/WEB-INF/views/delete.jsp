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
	<form:form action="deleteResult" modelAttribute="delete" method="post">
		<div>
			<p>
				<label><fmt:message key="form.lbl.product_id" /></label>
				<form:input path="productId" />
				<form:errors path="productId" cssStyle="color: red" />
			</p>
		</div>
		<form:button name="delete">
			<fmt:message key="form.lbl.delete" />
		</form:button>
	</form:form>
	<a href="top"><fmt:message key="form.lbl.back" /></a>

</body>
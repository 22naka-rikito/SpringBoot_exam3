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
<title>検索</title>
</head>
<body>
	<h1>検索条件または登録情報を入力して下さい</h1>
	<c:if test="${not empty msg}">
		<fmt:message key="form.lbl.msg" />
	</c:if>
	<form:form action="searchResult" modelAttribute="top" method="post">
		<div>
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
		<form:button name="find">
			<fmt:message key="form.lbl.find" />
		</form:button>
		<form:button name="insert">
			<fmt:message key="form.lbl.insert" />
		</form:button>
	</form:form>
</body>
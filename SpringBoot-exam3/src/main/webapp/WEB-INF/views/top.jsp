<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索</title>
</head>
<body>
	<p>検索条件を入力して下さい</p>
	<form:form action="searchResult" modelAttribute="top" method="post">
		<div>
			<p>
				<label>product_name</label>
				<form:input path="productName" />
			</p>
			<p>
				<label>price</label>
				<form:input path="price" />
			</p>
		</div>
		<form:button name="find">検索</form:button>
		<form:button name="insert">登録</form:button>
	</form:form>
</body>
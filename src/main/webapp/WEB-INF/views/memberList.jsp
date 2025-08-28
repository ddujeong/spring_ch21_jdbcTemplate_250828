<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 목록</title>
</head>
<body>
	<h2>멤버 목록</h2>
	<hr>
	<form action="">
		<table border="1" cellspacing ="0" cellpadding="0" width="800px">
			<tr>
				<th>아이디</th>
				<th>이 름</th>
				<th>나 이</th>
			</tr>
			<c:forEach var="mDto" items="${mDtos }">
			<tr>
				<td>${mDto.memberid }</td>
				<td>${mDto.membername }</td>
				<td>${mDto.memberage }</td>
			</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>
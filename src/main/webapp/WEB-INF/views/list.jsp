<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글목록</title>
</head>
<body>
	<a href="list"><h2>자유게시판 글목록</h2></a>
	<hr>
	<form action="search">
		<input type="text" name="searchKey">
		<input type="submit" value="검 색">
	</form>
	<br>
	<table border="1" cellspacing="0" cellpadding="0" width="1000">
		<tr>
			<th>번 호</th>
			<th width="500">제 목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>		
		
		<c:forEach items="${fboardDtos}" var="fboardDto">
		<tr>
			<td>${fboardDto.fbnum}</td>
			<td>
				<a href="content_view?fbnum=${fboardDto.fbnum}">${fboardDto.fbtitle}</a>
			</td>
			<td>${fboardDto.fbname}</td>
			<td>${fboardDto.fbdate}</td>
			<td>${fboardDto.fbhit}</td>
		</tr>
		</c:forEach>
		
		<tr>
			<td colspan="5">
				<input type="button" value="글쓰기" onclick="javascript:window.location.href='write_form'">
			</td>
		</tr>
	</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글쓰기</title>
</head>
<body>
	<h2>자유게시판 글쓰기</h2>
	<hr>
	<table border="1" cellspacing="0" cellpadding="0" width="600">
		<form action="write">
		<tr>
			<td>제 목</td>
			<td><input type="text" name="fbtitle" size="60"></td>
		</tr>
		<tr>
			<td>이 름</td>
			<td><input type="text" name="fbname" size="60"></td>
		</tr>
		<tr>
			<td>내 용</td>
			<td>
				<textarea rows="10" cols="50" name="fbcontent"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="글입력">&nbsp;&nbsp;
				<input type="button" value="글목록" onclick="javascript:window.location.href='list'">
			</td>
		</tr>
		</form>
	</table>
</body>
</html>
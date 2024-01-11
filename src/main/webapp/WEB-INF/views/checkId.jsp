<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<% 
 		String idcheck = request.getAttribute("idFlag").toString();  // 컨트롤러에서 model 객체에 넣어준 값을 빼는 방법
 		
 		if (idcheck.equals("1")) {  // 가입가능한 아이디
 	%>	
 		<script type="text/javascript">
 			alert('사용가능한 이이디 입니다.')
 			history.go(-1);
 		</script>
	<%
 		} else {
 	%>
 		<script type="text/javascript">
 			alert('이미 있는 아이디 입니다.')
 			history.go(-1);
 		</script>
 	<%
 		}
 	%>
 	
</body>
</html>
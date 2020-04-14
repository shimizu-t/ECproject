<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="web.*"%>
<%
	//カテゴリー名用
	Categorybean categorybean = new Categorybean();
	ArrayList<Categorybean> categorylists = new ArrayList<Categorybean>();
	categorylists = (ArrayList<Categorybean>) session.getAttribute("categoryname");
%>



<!DOCTYPE html>
<html lang="ja">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

	<h1>検索</h1>
	<br>
	<form action="http://localhost:8080/ECproject/SerchServlet"
		method="post">
		<input type="text" name="name"> <input type="submit"
			value="serch">
	</form>
	<br>
	<select name="category">
		<option selected></option>
		<%
			for (int i = 0; i < categorylists.size(); i++) {
		%>
		<%
			categorybean = categorylists.get(i);
		%>
		<option value="<%=categorybean.getCat_id()%>"><%=categorybean.getCat_name()%></option>
		<%
			}
		%>
	</select>
	<br>
	<br>
	<jsp:include page="Serchresult.jsp" />
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>
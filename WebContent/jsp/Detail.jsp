<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="web.Productbean"%>
<%
	Productbean productbean = new Productbean();
%>
<%
	ArrayList<Productbean> detaillist2 = new ArrayList<Productbean>();
%>
<%
	detaillist2 = (ArrayList<Productbean>) request.getAttribute("detailresult");
	Object result = request.getAttribute("detailresult");
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
	商品詳細
	<br>
	<%
		if (result != null) {
			//listの大きさ分だけまわす
	%>
	<%
		//listに格納しているbeanを１つ１つとりだして表示している
			productbean = detaillist2.get(0);
	%>
	<img src="<%=productbean.getPro_img()%>" alt="商品画像" title="商品画像">
	<br> 商品番号：<%=productbean.getPro_cd()%>
	<br> 商品名：<%=productbean.getPro_name()%>
	<br> カテゴリ名：<%=productbean.getCat_id()%>
	<br> 価格：<%=productbean.getPro_price()%>
	<br> 在庫数：<%=productbean.getStock_no()%>
	<br> 商品案内：<%=productbean.getPro_msg()%>
	<%
		}
	%>
	<br>
	<form action="http://localhost:8080/ECproject/CartServlet"
		method="post">
		<%
			productbean = detaillist2.get(0);
		%>
		<input type="hidden" name="pro_name"
			value=<%=productbean.getPro_name()%>> <input type="hidden"
			name="pro_price" value=<%=productbean.getPro_price()%>> <input
			type="hidden" name="pro_cd" value=<%=productbean.getPro_cd()%>>
		<select name="stock">
			<option selected></option>
			<%
				int zaiko = productbean.getStock_no();
			%>
			<%
				for (int i = 0; i <= zaiko; i++) {
			%>
			<option value="<%=i%>"><%=i%></option>
			<%
				}
			%>
		</select> <input type="submit" value="カートへ">
	</form>
	<br>
	<button type="button" onclick="history.back()">検索に戻る</button>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
<%@ page import="web.Productbean"%>
    <%
	Productbean productbean = new Productbean();
%>
<%
	ArrayList<Productbean> productlists = new ArrayList<Productbean>();
%>
<%
	productlists = (ArrayList<Productbean>)request.getAttribute("result");
	Object result = request.getAttribute("result");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<title>検索結果</title>
</head>
<body>
<%
	if(result != null){
		//listの大きさ分だけまわす
		for (int i = 0; i < productlists.size(); i++) {
	%>
	<%
		//listに格納しているbeanを１つ１つとりだして表示している
			productbean = productlists.get(i);
	%>
	商品番号：<%=productbean.getPro_cd()%>
	<br>
	商品名：<%=productbean.getPro_name()%>
	<br>
	価格：<%=productbean.getPro_price()%>
	<br>
	<form action="http://localhost:8080/ECproject/DetailSurvlet" method="POST">
	<input type = "hidden"  name="pro_cd" value=<%=productbean.getPro_cd()%>>
	<input type = "submit" value = "詳細">
	</form>
	<br>
	<br>
	<%
		}
	}else if(result ==null){
		System.out.println("検索結果がありません");
	}
	%>
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
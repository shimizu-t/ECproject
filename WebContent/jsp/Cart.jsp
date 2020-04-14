<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
商品：　
<%=request.getAttribute("name") %>
　価格：
<%=request.getAttribute("price") %>
　注文数：
<%=request.getAttribute("order") %>
<br>
消費税：
<%=request.getAttribute("tax") %>
<br>
合計金額：
<%=request.getAttribute("total") %>
<br>
<form action="http://localhost:8080/ECproject/PurchaseServlet" method="POST">
<input type= "hidden" name= "total" value=<%=request.getAttribute("total") %>>
<input type= "hidden" name= "name" value=<%=request.getAttribute("name") %>>
<input type= "hidden" name= "price" value=<%=request.getAttribute("price") %>>
<input type= "hidden" name= "order" value=<%=request.getAttribute("order") %>>
<input type= "hidden" name= "tax" value=<%=request.getAttribute("tax") %>>
<input type= "hidden" name= "cd" value=<%=request.getAttribute("cd") %>>
<input type="submit" value="購入">
</form>
<br>

<input type="button" value="商品検索画面に戻る" onclick="window.location='jsp/Serch.jsp'">

</body>
</html>
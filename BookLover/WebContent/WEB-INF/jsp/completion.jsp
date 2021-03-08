<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String userName=(String)session.getAttribute("userName"); %>
    <% String newPass=(String)session.getAttribute("newPass"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録完了</title>
</head>
<body>
<p><%= userName%>さん</p>
<p><%= newPass %></p>
<p>登録完了しました。</p>
<a href="/BookLover">TOPに戻る</a>
</body>
</html>
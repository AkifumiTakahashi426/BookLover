<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
<h1>新規登録</h1>
<hr>
<form action="/BookLover/Main" method="post">
ユーザー名：<input type="text" name="userName"><br>
パスワード：<input type="password" name="newPass"><br>
<input type="hidden" name="menu" value="2">
<input type="submit" value="登録">

</form>

</body>
</html>
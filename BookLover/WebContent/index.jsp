<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
</head>
<body>
<h1>♡BookLover♡</h1>
<hr>
<form action="/BookLover/Main" method="post">
ユーザーID：<input type="text" name="userName"><br>
パスワード：<input type="password" name="pass"><br>
<input type="hidden" name="menu" value="1">
<input type="submit" value="ログイン">

</form>
<br>
<a href="/BookLover/Main?menu=4">新規登録</a>



</body>
</html>
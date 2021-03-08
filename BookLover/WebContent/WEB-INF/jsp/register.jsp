<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="beans.Book,dao.AccountDAO,dao.AccountRegisterDAO,model.User,java.util.List,java.util.ArrayList" %>

    <%-- <%
    ArrayList<Book> bookList = (List<Book>)session.getAttribute("bookList");

    %> --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>書籍登録</title>
</head>
<body>
<h1>書籍登録</h1>
<h3>検索</h3>

    <form action="/BookLover/Register.servlet?search" method="post">
    タイトル<br><input type="text" name="title" value="title">
    ISBN<br><input type="text" name="title" value="identifier">
    <input type="submit" name="action "value="検索" >
    </form>
    <hr>



       <table border="1">
       <tr>
       <th>タイトル</th>
       <th>お気に入り</th>
       <th>持ってる</th>
       </tr>
       <%-- <% if(Book book:bookList){%> --%>
       <%-- <%for(int i=0;  i< bookList.length(); i++){ %> --%>
       <tr>
       <td>
      <%--  <%= book.getTitle()%> --%>
       </td>
       <tr>
       <td>
       <form action="/BookLover/Register.servlet?buy" method="post">
       <input type="button" name="action" value="buy">
       </form>

       </td>
       </tr>
       <tr>
       <td>
        <form action="/BookLover/Register.servlet?want" method="post">
       <input type="button" name="" value="want">
       </form>
       </td>
       </tr>
       <%-- <%} %>
       <%}else{ %>

       <% }%> --%>
       </table>



</body>
</html>
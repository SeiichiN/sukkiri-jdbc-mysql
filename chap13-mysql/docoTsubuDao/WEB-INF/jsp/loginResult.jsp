<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="model.User" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>

<!doctype html>
<html lang="ja">
  <head>
    <meta charset="UTF-8"/>
    <title>どこつぶ</title>
  </head>
  <body>
    <h1>どこつぶログイン</h1>
    <% if (loginUser != null) { %>
      <p>ログインに成功しました</p>
      <p>ようこそ<%= loginUser.getName() %>さん</p>
      <a href="/docoTsubuDao/Main">つぶやき投稿/閲覧へ</a>
    <% } else { %>
      <p>ログインに失敗しました</p>
      <a href="/docoTsubuDao/">TOPへ</a>
    <% } %>
  </body>
</html>

<!-- 修正時刻： Thu Jul  2 09:54:29 2020 -->

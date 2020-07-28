<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="model.User, model.Mutter, java.util.List" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
// get Tsubuyaki List
List<Mutter> mutterList = (List<Mutter>) request.getAttribute("mutterList");
// get errorMsg
String errorMsg = (String) request.getAttribute("errorMsg");
%>

<!doctype html>
<html lang="ja">
  <head>
    <meta charset="UTF-8"/>
    <title>どこつぶ</title>
  </head>
  <body>
    <h1>どこつぶメイン</h1>
    <p>
      <%= loginUser.getName() %>さん、ログイン中
      <a href="/docoTsubuDao/Logout">ログアウト</a>
    </p>
    <p><a href="/docoTsubuDao/Main">更新</a></p>
    <form action="/docoTsubuDao/Main" method="post">
      <input type="text" name="text"/>
      <input type="submit" value="つぶやく"/>
    </form>
    <% if (errorMsg != null) { %>
      <p><%= errorMsg %></p>
    <% } %>
    <% for (Mutter mutter : mutterList) { %>
      <p><%= mutter.getUserName() %>: <%= mutter.getText() %></p>
    <% } %>
  </body>
</html>

<!-- 修正時刻： Tue Jul 28 05:49:32 2020 -->


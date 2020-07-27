<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ include file="/common.jsp" %>
<%
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月dd日");
String today = sdf.format(date);
%>
<!doctype html>
<html lang="ja">
  <head>
    <meta charset="utf-8"/>
    <title>どこつぶ</title>
  </head>
  <body>
    <h1>どこつぶへようこそ</h1>
    <time><%= today %></time>
    <p>管理人:<%= name %></p>
    <form action="/docoTsubuDao/Login" method="post">
      ユーザー名:<input type="text" name="name"/><br/>
      パスワード:<input type="password" name="pass"/><br/>
      <input type="submit" value="ログイン"/>
    </form>
    <jsp:include page="/footer.jsp" /> 
  </body>
</html>

<!-- 修正時刻： Sat Jul  4 16:06:52 2020 -->

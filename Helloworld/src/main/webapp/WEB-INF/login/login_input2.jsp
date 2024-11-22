<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24. 11. 20.
  Time: 오후 4:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인 미니실습</h1>
<%--action : 서버에 전달할 경로, method는 형식--%>
<form action="/login/result2" method="post">
  <input type="text" name="email">
  <input type="password" name="password">
  <button type="submit">전송</button>
</form>
</body>
</html>

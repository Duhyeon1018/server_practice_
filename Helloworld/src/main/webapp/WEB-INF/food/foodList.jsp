<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 24. 11. 21.
  Time: 오전 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>
<body>
<h1>FoodList</h1>
<a href="/food/read?tno=5">하나 조회하기</a>

<c:forEach var="dto" items="${list}">
    <li>${dto}</li>
</c:forEach>



</body>
</html>

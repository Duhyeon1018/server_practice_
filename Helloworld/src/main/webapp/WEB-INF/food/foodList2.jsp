<%--
  Created by IntelliJ IDEA.
  User: it
  Date: 24. 11. 21.
  Time: 오전 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--JSTL 사용하기 준비 단계--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>todoRead 전체 </h2>
<a href="/food/read2">전체조회</a>
<ul>
    <c:forEach var="dto" items="${list}">
        <li>
            <span>${dto.tno}</span>
            <span><a href="/food/read2?tno=${dto.tno}">${dto.title}</a></span>
            <span>${dto.dueDate}</span>
            <span>${dto.finished? "완료": "미완료"}</span>
        </li>
    </c:forEach>
</ul>




</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>所有人员(jstl)</title>
    <style type="text/css">
        table {
            border-collapse: collapse;
            width: 600px;
        }

        th, td {
            border: 1px solid black;
            padding: 10px;
            margin: 0;
            text-align: center;
        }
    </style>
</head>
<body>
<%@ include file="top_ul.jsp" %>

<h1>所有人员(jstl)</h1>
<table>
    <tr>
        <th width="300">姓名</th>
        <th width="300">电话</th>
        <th width="300">生日</th>
    </tr>
    <c:forEach var="p" items="${requestScope.personlist }">
        <tr>
            <td align="center">${p.name }</td>
            <td align="center">${p.phone }</td>
            <td align="center">
                <fmt:formatDate value="${p.birthday }" pattern="yyyy-MM-dd hh:mm"/>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
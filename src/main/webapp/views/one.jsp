<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>查看一个</title>
    <script src="${pageContext.request.contextPath}/js/angular.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/do_ajax.js"></script>
    <style>
        table {
            border-collapse: collapse;
        }
        th, td {
            width: 200px;
            border: 1px solid black;
            padding: 10px;
            margin: 0;
            text-align: center;
        }
    </style>
</head>
<body>
<%@ include file="top_ul.jsp" %>

<h1>查看一个</h1>
<table ng-app="myApp" ng-controller="myCtrl">
    <tr>
        <td>姓名</td>
        <td>{{user.name}}</td>
    </tr>
    <tr>
        <td>身份证号</td>
        <td>{{user.idCard}}</td>
    </tr>
    <tr>
        <td>电话</td>
        <td>{{user.phone}}</td>
    </tr>
    <tr>
        <td>地址</td>
        <td>{{user.address}}</td>
    </tr>
</table>

<script>
    function getURLParameter(name) {
        return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [, ""])[1].replace(/\+/g, '%20')) || null;
    }
    var id = getURLParameter("id");
    var app = angular.module('myApp', []);
    app.controller('myCtrl', function($scope, $http) {
        $http.get("${pageContext.request.contextPath}/person/" + id).then(function(response) {
            $scope.user = response.data;
        });
    });
</script>

</body>
</html>

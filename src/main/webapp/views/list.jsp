<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>所有人员</title>
    <script src="${pageContext.request.contextPath}/js/angular.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/do_ajax.js"></script>
    <style>
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

<h1>所有人员</h1>
<table ng-app="myApp" ng-controller="myCtrl">
    <tr>
        <th>姓名</th>
        <th>电话</th>
        <th>生日</th>
        <th colspan="3">操作</th>
    </tr>
    <tr ng-repeat="user in users">
        <td>{{user.name}}<span ng-if="user.name=='果冻'"> (VIP)</span></td>
        <td>{{user.phone}}</td>
        <td>{{user.birthday | date : 'yyyy-MM-dd\Thh:mm'}}</td>
        <td>
            <a href="one.jsp?id={{user.id}}">查看</a>
        </td>
        <td>
            <a href="#" ng-click="deleteById(user.id)">删除</a>
        </td>
        <td>
            <a href="edit.jsp?id={{user.id}}">修改</a>
        </td>
    </tr>
</table>

<script>
    var app = angular.module('myApp', []);
    app.controller('myCtrl', function($scope, $http) {
        $http.get("${pageContext.request.contextPath}/person/all").then(function(response) {
            $scope.users = response.data;
            $scope.deleteById = function(itemId){
                doAjax('${pageContext.request.contextPath}/person/delete', itemId);
                location.reload();
            };
        });
    });
</script>

</body>
</html>

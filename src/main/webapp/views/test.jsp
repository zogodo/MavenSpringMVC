<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>增</title>
    <script src="../js/angular.min.js"></script>
</head>
<body>
<%@ include file="top_ul.jsp" %>

<div ng-app="myApp" ng-controller="myCtrl">

    名: <input type="text" ng-model="firstName"><br>
    姓: <input type="text" ng-model="lastName"><br>
    <br>
    姓名: {{firstName + " " + lastName}}
    <ul>
        <li ng-repeat="name in names">
            {{ name }}
        </li>
    </ul>
</div>

<script>
    var app = angular.module('myApp', []);
    app.controller('myCtrl', function($scope) {
        $scope.firstName= "John";
        $scope.lastName= "Doe";
        $scope.names=['Jani','Hege','Kai']
    });
</script>

<div ng-controller="ExampleController">
    <form novalidate action="${pageContext.request.contextPath}/person/add" method="post">
        <table>
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="name" ng-model="user.name"/></td>
            </tr>
            <tr>
                <td>身份证号码：</td>
                <td><input type="text" name="idCard" ng-model="user.idCard"/></td>
            </tr>
            <tr>
            <tr>
                <td>手机号：</td>
                <td><input type="text" name="phone" ng-model="user.phone"/></td>
            </tr>
            <tr>
                <td>地址：</td>
                <td><input type="text" name="address" ng-model="user.address"/></td>
            </tr>
            <tr>
                <td>
                    <input type="submit" />
                    <input type="button" ng-click="reset()" value="Reset" />
                    <input type="button" ng-click="update(user)" value="Save" />
                </td>
            </tr>
        </table>
    </form>
    <pre>user = {{user | json}}</pre>
    <pre>master = {{master | json}}</pre>
</div>

<script>

    angular.module('formExample', [])
            .controller('ExampleController', ['$scope', '$http', function($scope) {
                $scope.master = {};

                $scope.update = function(user) {
                    $scope.master = angular.copy(user);
                    $http.get("${pageContext.request.contextPath}/person/saveperson").then(function(response) {
                        //$scope.users = response.data;
                        alert(response.date)
                    });
                };

                $scope.reset = function() {
                    $scope.user = angular.copy($scope.master);
                };

                $scope.reset();
            }]);
</script>

</body>
</html>

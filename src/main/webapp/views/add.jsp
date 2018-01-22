<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加用户</title>
    <script src="../js/jquery-3.2.1.min.js"></script>
    <script src="../js/jquery.form.js"></script>
</head>

<body ng-app="formExample">
<%@ include file="top_ul.jsp" %>

<h1>添加用户</h1>
<form action="${pageContext.request.contextPath}/person/add" id="form1" method="post" onsubmit="return check()">
    <table>
        <tr>
            <td>姓名：<span style="color: orangered">*</span></td>
            <td><input type="text" name="name" id="name" required/></td>
        </tr>
        <tr>
            <td>手机号：</td>
            <td><input type="text" name="phone"/></td>
        </tr>
        <tr>
            <td>生日：</td>
            <td><input type="datetime-local" name="birthday"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" />
            </td>
        </tr>
    </table>
</form>

<script>
    $(document).ready(function () {
        var options = {
            success: function (re) {
                alert(re);
                if (re == "添加成功") {
                    location.href = "list.jsp";
                }
            },
            error: function (re) {
                alert("服务器错误 " + re.status + "，添加失败！");
            }
        };
        $("#form1").ajaxForm(options);
    });
</script>

</body>
</html>

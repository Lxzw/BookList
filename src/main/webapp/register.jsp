<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<html>
<head>
    <link href="css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
    <div class="menu">
        <div><p>当前用户:</p></div>
        <div><p><a href="/FileManager/index.jsp">登录</a></p></div>
        <div><p><a>注册用户</a></p></div>
        <div><p><a href="#">我的文件</a></p></div>
        <div><p><a href="#">全部文件</a></p></div>
        <div><p><a href="#">全部用户</a></p></div>
    </div>
    <div class="content">
        <div class="login">
            <p><%=request.getAttribute("info") %><p>
            <form action="/FileManager/Register" method="post">
              <p>注册新用户</p>
              <p>用户名： <input type="text" name="username"/></p>
              <p>电子邮件:<input type="text" name="email"/></p>
              <p>密码：<input type="password" name="password1"/></p>
              <p>重复密码：<input type="password" name="password2"/></p>
              <p><input type="submit"/>&nbsp; <input type="reset"/>
            </form>
        </div>
    </div>
</body>
</html>

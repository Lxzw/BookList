<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<html>
<head>
    <link href="css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
    <div class="menu">
        <div><p>当前用户:</p></div>
        <div><p><a>登录</a></p></div>
        <div><p><a href="/FileManager/register.jsp">注册用户</a></p></div>
        <div><p><a href="#">我的文件</a></p></div>
        <div><p><a href="#">全部文件</a></p></div>
        <div><p><a href="#">全部用户</a></p></div>
    </div>
    <div class="content">
        <div class="login">
            <form action="/FileManager/Accessor">
                <h3>用户登录</h3>
                <p>用户名<input type="text" name="username"/></p>
                <p>口令<input type="password" name="password"/></p>
                <p><input type="submit" value="登录"/>
            </form>
        </div>
    </div>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.l.filemanager.model.*,java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" type="text/css" rel="stylesheet">
<title>用户信息显示</title>
</head>
<body>
 <div class="menu">
        <div><p>当前用户:</p></div>
        <div><p><a href="/FileManager/index.jsp">登录</a></p></div>
        <div><p><a href="/FileManager/register.jsp">注册用户</a></p></div>
        <div><p><a href="#">我的文件</a></p></div>
        <div><p><a href="#">全部文件</a></p></div>
        <div><p><a href="#">全部用户</a></p></div>
    </div>
    <div class="content">
        <div class="myfile">
            <%List<User>  users = (List<User>)session.getAttribute("users");%>
            <% for (User u : users) { %>
                <p> 用户名 ： <%=u.getName() %> </p>
            <% } %>
        </div>
    </div>
</body>
</html>
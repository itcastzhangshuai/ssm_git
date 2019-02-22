<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

<a href="/user/findAll">测试</a>
</body>
<form action="/user/save" method="post">
    姓名：<input type="text" name="name"><br/>
    金额：<input type="text" name="money"><br/>
    <input type="submit" value="提交">
</form>
</html>

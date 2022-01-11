<%--
  Created by IntelliJ IDEA.
  User: zzk
  Date: 2022/1/4 0004
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../css/index.css">
</head>
<body>
<p style="    font-size: 26px;
    text-align: center;">${name}</p>
<button class="success" onclick="
        window.parent.document.body.removeChild(window.parent.document.getElementsByClassName('bgObj')[0]);
        window.parent.document.body.removeChild(window.parent.document.getElementsByClassName('msgObj')[0]);"
        >确定</button>
</body>
</html>

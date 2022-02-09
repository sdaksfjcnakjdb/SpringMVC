<%--
  Created by IntelliJ IDEA.
  User: zzk
  Date: 2021/12/27 0027
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>上传书籍</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/index.css">
</head>
<body>
<div class="upload">
    <form action="upload" method="post" enctype="multipart/form-data">
        <a>书名:</a><input type="String" name="book">
        <a>作者:</a><input type="String" name="author">
        <a>定价:</a><input type="int" name="pay">
        <a>书籍:</a><input type="file" name="file" width="120px">
        <a>封面:</a><input type="file" name="img" width="120px">
        <input class="userid" name = "userid" type="int" value="${sessionScope.user.id}">
        <input type="submit"
               value="上传" style="
            width: 150px;
            height: 50px;
            margin-left: 37%;">
    </form>

</div>
</body>
</html>

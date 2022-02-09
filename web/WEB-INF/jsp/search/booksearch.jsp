<%--
  Created by IntelliJ IDEA.
  User: zzk
  Date: 2022/1/11 0011
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${name}</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/search.css">
</head>
<body>
<div class="searchchose">
    <form action="search" method="post" enctype="multipart/form-data">
        <input class = "personid" name = "personid" type = "String"  style="display: none">
        <input class = "bookid" name = "bookid" type = "String"  style="display: none">
        <input class = "bookname" name = "bookname" type = "String"  style="display: none">
        <input type="submit" value="添加"style="
                width: 150px;
                height: 50px;
                margin: 75%;
                margin-left: 73%;
                position: absolute;">
    </form>
</div>
</body>
<script>
    document.getElementsByClassName("personid")[0].setAttribute("value","${sessionScope.user.id}");
    document.getElementsByClassName("bookid")[0].setAttribute("value","${book.id}");
    document.getElementsByClassName("bookname")[0].setAttribute("value","${book.name}");
    var book =document.getElementsByClassName("searchchose")[0];
    var img = document.createElement("img");
    var bookname = document.createElement("p");
    var author = document.createElement("p");
    var pont = document.createElement("p");
    var pay = document.createElement("p");
    img.setAttribute("class","png");
    img.setAttribute("src","../upload/img/"+"${book.img}");
    bookname.setAttribute("class","bookname");
    bookname.innerHTML = "《"+"${book.name}" + "》";
    author.setAttribute("class","author");
    author.innerHTML = "作者："+"${book.author}";
    pont.setAttribute("class","pont");
    pont.innerHTML = "下载次数:"+${book.pont};
    pay.setAttribute("class","pay");
    pay.innerHTML = "书籍定价:"+${book.pay};

    book.appendChild(img);
    book.appendChild(bookname);
    book.appendChild(author);
    book.appendChild(pont);
    book.appendChild(pay);
</script>
</html>

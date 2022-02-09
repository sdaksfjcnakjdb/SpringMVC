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
    <title>下载书籍</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/index.css">
</head>
<body>
<div class="dowmload">
    <form action="down" method="post" enctype="multipart/form-data">
        <input class = "bookname" name = "bookname" type = "String"  style="display: none">
        <input class = "bookid" name = "bookid" type = "String"  style="display: none">
        <input type="submit" value="下载"style="
                width: 150px;
                height: 50px;
                margin: 75%;
                margin-left: 73%;
                position: absolute;">
    </form>


</div>
</body>
<script>
    var targetEle = window.parent.$("#filedownload");
    var  paramMap=null;//置空
    if(!!targetEle) {
        var url = targetEle.attr("src"); //取得iframe的url
        var ret;
        paramMap = {};//初始化结果集
        var urls = url.split('?')[1];
        var list = urls.split('&');
        for (let i = 0; i < list.length; i++) {
            key = list[i].split('=')[0];
            value = list[i].split('=')[1];
            paramMap[key] = value;
        }
    }
    document.getElementsByClassName("bookname")[0].setAttribute("value",paramMap.fileurl);
    document.getElementsByClassName("bookid")[0].setAttribute("value",paramMap.id);
    var book =document.getElementsByClassName("dowmload")[0];
    var img = document.createElement("img");
    var bookname = document.createElement("p");
    var author = document.createElement("p");
    var pont = document.createElement("p");
    var pay = document.createElement("p");
    img.setAttribute("class","png");
    img.setAttribute("src","../upload/img/"+paramMap.img);
    bookname.setAttribute("class","bookname");
    bookname.innerHTML = "《"+paramMap.name+"》";
    author.setAttribute("class","author");
    author.innerHTML = "作者："+paramMap.author;
    pont.setAttribute("class","pont");
    pont.innerHTML = "下载次数:"+paramMap.pont;
    pay.setAttribute("class","pay");
    pay.innerHTML = " 书籍定价:"+paramMap.pay;
    book.appendChild(img);
    book.appendChild(bookname);
    book.appendChild(author);
    book.appendChild(pont);
    book.appendChild(pay);
</script>
</html>

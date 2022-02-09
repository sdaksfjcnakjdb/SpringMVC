<%--
  Created by IntelliJ IDEA.
  User: zzk
  Date: 2022/1/10 0010
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
    <script type="text/javascript" src="../js/search.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="../css/search.css" type="text/css">
    <script type="text/javascript" src="../js/search.js"></script>
    <title>${name}</title>
</head>
<body>
    <input class = "search" type="search" placeholder="Search">
    <select  class = "searchtype" id="sid" onchange="selectcity()">
        <option>书名</option>
        <option>作者</option>
        <option>上传者</option>
    </select>
<button class = "searchsure"  onclick="search()">搜索</button>
<div class="books">

</div>
</body>
<script>
    initialization();
    //初始化

    function initialization(){
        var books = document.body.getElementsByClassName("books")[0];
        var length =${listbook.size()};
        const list = ${listbook};
        for (let i = 0; i < length; i++) {
            var book = document.createElement("div");
            var img = document.createElement("img");
            var bookname = document.createElement("p");
            var author = document.createElement("p");
            var imgadd = document.createElement("img");
            img.setAttribute("class","png");
            img.setAttribute("src","../upload/img/"+list[i].img);
            bookname.setAttribute("class","bookname");
            author.setAttribute("class","author");
            bookname.innerHTML = "《"+list[i].name+"》";
            author.innerHTML = "作者："+list[i].author;
            book.appendChild(img);
            book.appendChild(bookname);
            book.appendChild(author);
            book.setAttribute("class","book");
            book.setAttribute("onclick","chose('"+
                list[i].id + "','"+//书籍id
                list[i].name+"','"+//书籍名称
                list[i].img+"','"+//书籍封面
                list[i].author+"','"+//书籍作者
                list[i].fileUrl+"','"+//书籍地址
                list[i].loadperson+"','"+//上传者
                list[i].pont+"','"+//下载量
                list[i].pay+//定价
                "','加入书库',600,535,'chose','chose')");
            books.appendChild(book);
        }
    }


    function searchadd(list,books,i){
        var book = document.createElement("div");
        var img = document.createElement("img");
        var bookname = document.createElement("p");
        var author = document.createElement("p");
        var imgadd = document.createElement("img");
        img.setAttribute("class", "png");
        img.setAttribute("src", "../upload/img/" + list[i].img);
        bookname.setAttribute("class", "bookname");
        author.setAttribute("class", "author");
        bookname.innerHTML = "《" + list[i].name + "》";
        author.innerHTML = "作者：" + list[i].author;
        book.appendChild(img);
        book.appendChild(bookname);
        book.appendChild(author);
        book.setAttribute("class", "book");
        book.setAttribute("onclick", "chose('" +
            list[i].id + "','" +//书籍id
            list[i].name + "','" +//书籍名称
            list[i].img + "','" +//书籍封面
            list[i].author + "','" +//书籍作者
            list[i].fileUrl + "','" +//书籍地址
            list[i].loadperson + "','" +//上传者
            list[i].pont+"','"+//下载量
            list[i].pay+//定价
            "','加入书库',600,535,'chose','chose')");
        books.appendChild(book);
        return books;
    }

    function searchtype(input,type){
        var books = document.body.getElementsByClassName("books")[0];
        var length =${listbook.size()};
        const list = ${listbook};
        for (let i = 0; i < length; i++) {
            if (input == ''){
                books = searchadd(list,books,i);
            }
            else {
                if (type == 0 && list[i].name == input) {
                    books = searchadd(list, books, i);
                }
                if (type == 1 && list[i].author == input) {
                    books = searchadd(list, books, i);
                }
                if (type == 2 && list[i].loadperson == input) {
                    books = searchadd(list, books, i);
                }
            }
        }
    }

    function search(){
        document.getElementsByClassName("books")[0].innerHTML = ""
        var input = document.getElementsByClassName("search")[0].value;
        var type = document.getElementsByClassName("searchtype")[0].value;
        if (type == "书名"){
            searchtype(input,0);
        }else if (type == "作者") {
            searchtype(input, 1);
        }else if (type == "上传者") {
            searchtype(input, 2);
        }
    }
</script>
</html>

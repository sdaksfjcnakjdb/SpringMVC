<%--
  Created by IntelliJ IDEA.
  User: ly
  Date: 2018/3/13
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
    <script type="text/javascript" src="../js/stype.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/index.css">
    <script type="text/javascript" src="../js/stype.js"></script>
    <title>主页面</title>
</head>
    <div class="head">
        <button class="normaluser" onclick="getvip(600,530,'normaluser','normaluser')">普通会员</button>
        <button onclick="repassword()" style="margin-right: 23px;">修改密码</button>
        <a >登陆用户：${sessionScope.user.name};金额：${sessionScope.user.money}</a>
    </div>
    <p class="br"> user sessionScope:${sessionScope.user}</p>
    <form action="load" method="post" class="form">
        <tr>
            <td><input class="submit" type="submit" value="注销登录"></td>
        </tr>
    </form>

<button onclick="upload('上传书籍文件',600,550,'fileupload','fileupload')" class = "uploadfiles">上传文件</button>
<div class="books">
</div>

</body>



 <script>
     Alert("登陆成功！欢迎用户${sessionScope.user.name}进入系统");
     initialization();
     if (${sessionScope.user.type} == 1){//vip会员
        document.getElementsByClassName("normaluser")[0].innerHTML = "vip会员";
         document.getElementsByClassName("normaluser")[0].setAttribute("onclick","showvip(600,530,'vipuser','vipuser')")
         document.getElementsByClassName("normaluser")[0].setAttribute("class","vipuser")
     }
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
             var pay = document.createElement("p");
             img.setAttribute("class","png");
             img.setAttribute("src","../upload/img/"+list[i].img);
             bookname.setAttribute("class","bookname");
             author.setAttribute("class","author");
             pay.setAttribute("class","pay");
             bookname.innerHTML = "《"+list[i].name+"》";
             author.innerHTML = "作者："+list[i].author;
             pay.innerHTML = "价格："+list[i].pay;
             book.appendChild(img);
             book.appendChild(bookname);
             book.appendChild(author);
             // book.appendChild(pay);
             book.setAttribute("class","book");
             book.setAttribute("onclick","dowmload('"+
                 list[i].id + "','"+//书籍id
                 list[i].name+"','"+//书籍名称
                 list[i].img+"','"+//书籍封面
                 list[i].author+"','"+//书籍作者
                 list[i].fileUrl+"','"+//书籍地址
                 list[i].loadperson+"','"+//上传者
                 list[i].pont+"','"+//下载量
                 list[i].pay+//定价
                 "','下载文件',600,535,'filedownload','filedownload')");
             books.appendChild(book);
         }
         var bookadd = document.createElement("div");
         var imgadd = document.createElement("img");
         bookadd.setAttribute("class","bookadd");
         bookadd.setAttribute("onclick","search('搜索书籍',document.body.offsetWidth*0.4,window.screen.height*0.8,'searchbook','searchbook')");
         imgadd.setAttribute("src","../img/bookadd.jpg");
         imgadd.setAttribute("class","imgadd");
         bookadd.appendChild(imgadd);
         <%--var id = document.createElement("p");--%>
         <%--id.setAttribute("class","userid");--%>
         <%--id.innerHTML = ${sessionScope.user.id};--%>
         // bookadd.appendChild(id);
         books.appendChild(bookadd);
     }
     //提示框
     function Alert(str) {
         var msgw,msgh,bordercolor;
         msgw=400;//提示窗口的宽度
         msgh=200;//提示窗口的高度
         titleheight=25 //提示窗口标题高度
         bordercolor="#336699";//提示窗口的边框颜色
         titlecolor="#99CCFF";//提示窗口的标题颜色
         var sWidth,sHeight;
//获取当前窗口尺寸
         sWidth = document.body.offsetWidth;
         sHeight = document.body.offsetHeight;
// //背景div
         var bgObj=document.createElement("div");
         var iWidth = document.documentElement.clientWidth;
         var iHeight = document.documentElement.clientHeight;
         bgObj.setAttribute('id','alertbgDiv');
         bgObj.style.position="absolute";
         bgObj.style.top="0";
         bgObj.style.background="#E8E8E8";
         bgObj.style.filter="progid:DXImageTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75";
         bgObj.style.opacity="0.6";
         bgObj.style.left="0";
         bgObj.style.width = sWidth + "px";
         bgObj.style.height = sHeight + "px";
         bgObj.style.zIndex = "10000";
         bgObj.style.cssText = "position:fixed;left:0px;top:0px;width:" + iWidth + "px;height:" + Math.max(document.body.clientHeight, iHeight) + "px;filter:Alpha(Opacity=30);opacity:0.3;background-color:#000000;z-index:101;";
         document.body.appendChild(bgObj);
//创建提示窗口的div
         var msgObj = document.createElement("div")
         msgObj.setAttribute("id","alertmsgDiv");
         msgObj.setAttribute("align","center");
         msgObj.style.background="white";
         msgObj.style.border="1px solid " + bordercolor;
         msgObj.style.position = "absolute";
         msgObj.style.left = "50%";
         msgObj.style.font="20px/130px Verdana, Geneva, Arial, Helvetica, sans-serif";
//窗口距离左侧和顶端的距离
         msgObj.style.marginLeft = "-225px";
//窗口被卷去的高+（屏幕可用工作区高/2）-150
         msgObj.style.top = document.body.scrollTop+(window.screen.availHeight/2)-150 +"px";
         msgObj.style.width = msgw + "px";
         msgObj.style.height = msgh + "px";
         msgObj.style.textAlign = "center";
         msgObj.style.lineHeight ="25px";
         msgObj.style.zIndex = "10001";
         document.body.appendChild(msgObj);
//提示信息标题
         var title=document.createElement("h4");
         title.setAttribute("id","alertmsgTitle");
         title.setAttribute("align","left");
         title.style.margin="0";
         title.style.padding="3px";
         title.style.background = bordercolor;
         title.style.filter="progid:DXImageTransform.Microsoft.Alpha(startX=20, startY=20, finishX=100, finishY=100,style=1,opacity=75,finishOpacity=100);";
         title.style.opacity="0.75";
         title.style.border="1px solid " + bordercolor;
         title.style.height="18px";
         title.style.font="12px Verdana, Geneva, Arial, Helvetica, sans-serif";
         title.style.color="white";
         title.innerHTML="提示信息";
         document.getElementById("alertmsgDiv").appendChild(title);
//提示信息
         var txt = document.createElement("p");
         txt.setAttribute("id","msgTxt");
         txt.style.margin="16px 0";
         txt.innerHTML = str;
         document.getElementById("alertmsgDiv").appendChild(txt);
//设置关闭时间
         window.setTimeout("closewin()",1000);
     }
     function closewin() {
         document.body.removeChild(document.getElementById("alertbgDiv"));
         document.getElementById("alertmsgDiv").removeChild(document.getElementById("alertmsgTitle"));
         document.body.removeChild(document.getElementById("alertmsgDiv"));
     }
 </script>

</html>
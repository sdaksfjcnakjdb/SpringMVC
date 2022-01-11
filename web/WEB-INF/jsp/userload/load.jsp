<%--
  Created by IntelliJ IDEA.
  User: zzk
  Date: 2021/12/20 0020
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <link>
    <title>${name}</title>
  <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
    <script type="text/javascript" src="../js/stype.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/load.css">
  </head>
  <body>
  <div class="load">
  <form action="getFrom" method="post">
    <table>
      <tr >
        <td><label>账户: </label></td>
        <td><input type="text" id="name" name="name"></td>
      </tr>
      <tr class="name">
        <td><label>密码: </label></td>
        <td><input type="text" id="password" name="password"></td>
      </tr>

      <input class="submit" type="submit" value="登陆">


      <p class="toregis" onclick="window.location.href='/SpringMVC_war_exploded/hi/toregister'">没有账号?点我注册</p>
      <p class="findpassword" onclick="window.location.href='/SpringMVC_war_exploded/hi/topassword'">忘记密码?点我修改</p>


    </table>
  </form>
  </div>
  <div>
    <h1 class="tips">${tips}</h1>
  </div>
  </body>

<script>
  function toregis(){
    document.getElementsByClassName("load")[0].style.display = "none"
    document.getElementsByClassName("register")[0].style.display = "block"
  }
  function load(){
    document.getElementsByClassName("load")[0].style.display = "block"
    document.getElementsByClassName("register")[0].style.display = "none"
  }
</script>
</html>

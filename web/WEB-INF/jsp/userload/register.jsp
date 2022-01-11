<%--
  Created by IntelliJ IDEA.
  User: zzk
  Date: 2021/12/22 0022
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>${name}</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
    <script type="text/javascript" src="../js/stype.js"></script>
<link rel="stylesheet" type="text/css" href="../css/load.css">
</head>
<body>
<div class = "register">
    <form action="register" method="post">
        <table>
            <tr >
                <td><label>账户: </label></td>
                <td><input type="text" id="namere" name="name"></td>
            </tr>
            <tr class = "regise">
                <td><label>密码: </label></td>
                <td><input type="text" id="passwordre" name="password"></td>
            </tr>
            <tr >
                <td><label>手机号: </label></td>
                <td><input type="text" id="phonere" name="phone"></td>
            </tr>
            <input class="submit" type="submit" value="注册">

            <p class="toregis"  onclick="window.location.href='/SpringMVC_war_exploded/hi/load'">已有账号?点我登陆</p>
            <p class="findpassword" onclick="window.location.href='/SpringMVC_war_exploded/hi/topassword'">忘记密码?点我修改</p>
            s
        </table>
    </form>
</div>
<div>
    <h1 class="tips">${tips}</h1>
</div>
</body>
</html>
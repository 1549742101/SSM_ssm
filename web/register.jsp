<%@ page import="cn.com.guilongkeji.ssm.entity.User" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: xgl
  Date: 2019/11/5
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<%
    if(request.getAttribute("user")==null){//数据有可能来自上一次用户输入的数据
        User user=new User();
        request.setAttribute("user",user);}
%>
<a href="changeLocale?locale=zh_CH">中文</a>
<a href="changeLocale?locale=en_US">English</a>
<%--@elvariable id="user" type="entity.User"--%>
<form:form action="reg" method="POST" modelAttribute="user">
    <table border="0">
        <tr>
            <td>用户名：</td>
            <td>
                <form:input path="username" />*
                <form:errors path="username"></form:errors>
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <form:password path="password" />*
                <form:errors path="password"></form:errors>
                <form:errors path="sameNameAndPassword"></form:errors>
            </td>
        </tr>
        <tr>
            <td>确认密码：</td>
            <td>
                <form:password path="password2" />*
                <form:errors path="samePassword"></form:errors>
            </td>
        </tr>
        <tr>
            <td>性别：</td>
            <%
                Map<String, String> genders = new HashMap<String, String>();
                genders.put("1", "男");
                genders.put("0", "女");
                request.setAttribute("genders", genders);	%>
            <td><form:radiobuttons path="sex" items="${genders}" delimiter="&nbsp;" /></td>
        </tr>
        <tr>
            <%Map<String, String> works = new HashMap<String, String>();
                works.put("0", "学生");
                works.put("1", "老师");
                works.put("2", "工人");
                request.setAttribute("works", works);
            %>
            <td>工作：</td>
            <td><form:select path="work" items="${works}" />
        </tr>
        <tr>
            <td>个人爱好：</td>
            <%Map<String, String> favourites = new HashMap<String, String>();
                favourites.put("0", "影视娱乐");
                favourites.put("1", "电脑网络");
                favourites.put("2", "棋牌娱乐");
                request.setAttribute("favourites", favourites);
            %>
            <td><form:checkboxes path="favorite" items="${favourites}"/></td>
        </tr>
        <tr>
            <td>个人说明：</td>
            <td><form:textarea path="note" rows="3" cols="30"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit"  value="提交" name="submit"/>
                &nbsp;&nbsp;&nbsp; <input type="reset" value="重置" name="reset">
            </td>
        </tr>
        <tr><td></td><td></td></tr>
    </table>
</form:form>
</body>
</html>

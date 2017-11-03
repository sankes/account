<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="com.shankes.account.service.AccountService" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/2
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style type="text/css">
        <%-- ** --%>
    </style>
    <title>Title</title>
</head>
<body>

<%
    ServletContext servletContext = request.getSession().getServletContext();
    ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    AccountService accountService = (AccountService) context.getBean("accountService");
    String captchaKey = accountService.generateCaptchaKey();
%>
<div class="text-field">
    <h2>注册新账户</h2>
    <input name="signup" action="/SignUpServlet" method="post">
    <label>账户ID：</label><input type="text" name="id"></input></br>
    <label>Email：</label><input type="text" name="email"></input></br>
    <label>显示名称：</label><input type="text" name="name"></input></br>
    <label>密码：</label><input type="password" name="password"></input></br>
    <label>确认密码：</label><input type="password" name="confirm_password"></input></br>
    <label>验证码：</label><input type="text" name="captcha_value"></input></br>
    <input type="hidden" name="captcha_key" value="<%=captchaKey%>"/>
    <img src="<%=request.getContextPath()%>/CaptchaImageServlet?key=<%=captchaKey%>" alt="captcha key"></br>
    <button>确认并提交</button>
    </form>
</div>

</body>
</html>

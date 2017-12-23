package com.shankes.account.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 访问该路径和xml中配置路径的效果是一样的，可以不同，不互斥
//@WebServlet("/hello.view")

/*@WebServlet(
        name = "Hello",
        urlPatterns = {"/hello.view"},// urlPatterns={"/getUser","/userInfo"}
        loadOnStartup = 1 // 设置大于0的值(默认值为-1),较小数字的Servlet先初始化
)*/
public class ActivateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

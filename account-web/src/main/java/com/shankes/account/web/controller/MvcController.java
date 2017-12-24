package com.shankes.account.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 启动服务器，键入 http://localhost:8080/项目名/mvc/hello
 */
@Controller
@RequestMapping("/mvc")
public class MvcController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    /**
     * 处理局部异常（Controller内）
     *
     * @param ex
     * @return
     */
    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception ex) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("exception", ex);
        System.out.println("in testExceptionHandler");
        return mv;
    }

    /**
     * 处理局部异常（Controller内）
     *
     * @return
     */
    @RequestMapping("/error")
    public String error() {
        int i = 5 / 0;
        return "hello";
    }
}

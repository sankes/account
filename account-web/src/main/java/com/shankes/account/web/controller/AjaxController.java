package com.shankes.account.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.PrintWriter;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

    /**
     * pass the parameters to front-end using ajax
     * 前台用下面的Jquery代码调用
     * <p>
     * $(function(){
     * $("#btn").click(function(){
     * $.post("ajax/getPerson",{name:$("#name").val()},function(data){
     * alert(data);
     * });
     * });
     * });
     *
     * @param name
     * @param pw
     */
    @RequestMapping("/getPerson")
    public void getPerson(String name, PrintWriter pw) {
        pw.write("hello," + name);
    }

    @RequestMapping("/name")
    public String sayHello() {
        return "name";
    }
}

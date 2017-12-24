package com.shankes.account.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用@RequestParam注解指定参数的name
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    @RequestMapping(value = "/param")
    public String testRequestParam(@RequestParam(value = "id") Integer id,
                                   @RequestParam(value = "name") String name) {
        System.out.println(id + " " + name);
        return "/hello";
    }
}

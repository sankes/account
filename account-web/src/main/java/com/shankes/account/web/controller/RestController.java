package com.shankes.account.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 在前台可以用以下代码产生请求
 * <form action="rest/user/1" method="post">
 * <input type="hidden" name="_method" value="PUT">
 * <input type="submit" value="put">
 * </form>
 * <p>
 * <form action="rest/user/1" method="post">
 * <input type="submit" value="post">
 * </form>
 * <p>
 * <form action="rest/user/1" method="get">
 * <input type="submit" value="get">
 * </form>
 * <p>
 * <form action="rest/user/1" method="post">
 * <input type="hidden" name="_method" value="DELETE">
 * <input type="submit" value="delete">
 * </form>
 */
@Controller
@RequestMapping("/rest")
public class RestController {

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String get(@PathVariable("id") Integer id) {
        System.out.println("get" + id);
        return "/hello";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
    public String post(@PathVariable("id") Integer id) {
        System.out.println("post" + id);
        return "/hello";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public String put(@PathVariable("id") Integer id) {
        System.out.println("put" + id);
        return "/hello";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Integer id) {
        System.out.println("delete" + id);
        return "/hello";
    }
}

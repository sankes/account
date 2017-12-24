package com.shankes.account.web.controller;

import com.shankes.account.persist.demo.bean.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/json")
public class JsonController {

    @ResponseBody
    @RequestMapping("/user")
    public Customer get() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Michael");
//        customer.setBirth(new Date());
        customer.setContact("");
        return customer;
    }
}
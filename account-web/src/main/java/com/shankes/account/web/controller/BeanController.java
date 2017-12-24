package com.shankes.account.web.controller;

import com.shankes.account.persist.demo.bean.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bean")
public class BeanController {

    /**
     * boxing automatically
     *
     * @param customer
     * @return
     */
    @RequestMapping("/person1")
    public String toPerson(Customer customer) {
        System.out.println(customer.getName() + " " + customer.getContact());
        return "hello";
    }
}

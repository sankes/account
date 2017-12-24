package com.shankes.account.web.controller;

import com.shankes.account.persist.demo.bean.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/show")
public class ShowController {

    /**
     * pass the parameters to front-end
     *
     * 前台可在Request域中取到"customer"
     *
     * @param map
     * @return
     */
    @RequestMapping("/showCustomer")
    public String showCustomer(Map<String, Object> map) {
        Customer customer = new Customer();
        map.put("customer", customer);
        customer.setName("jack");
        customer.setContact("110");
        return "show";
    }
}

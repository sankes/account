package com.shankes.account.web.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/date")
public class DateController {

    /**
     * the parameter was converted in initBinder
     *
     * @param date
     * @return
     */
    @RequestMapping("/date")
    public String date(Date date) {
        System.out.println(date);
        return "hello";
    }

    /**
     * At the time of initialization,convert the type "String" to type "date"
     *
     * @param binder
     */
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),
                true));
    }
}

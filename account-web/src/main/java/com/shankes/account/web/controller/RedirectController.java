package com.shankes.account.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redirect")
public class RedirectController {

    /**
     * redirect
     *
     * @return
     */
    @RequestMapping("/redirect")
    public String redirect() {
        return "redirect:hello";
    }
}

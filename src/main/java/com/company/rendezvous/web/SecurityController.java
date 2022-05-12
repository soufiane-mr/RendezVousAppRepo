package com.company.rendezvous.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/loginn")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/403")
    public String errorPage(){
        return "403";
    }
}

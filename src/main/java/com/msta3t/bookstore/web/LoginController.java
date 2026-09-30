package com.msta3t.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String getLoginPage() {
        return "loginPage";
    }
}

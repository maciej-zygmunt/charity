package pl.coderslab.charity.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user/")
public class UserController {
    @GetMapping(path="/")
    public String dispalyUser(@AuthenticationPrincipal UserDetails user, Model model) {
        model.addAttribute("username",user.getUsername());
        return "user";
    }
}

package pl.coderslab.charity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dao.UserDao;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.security.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/registration")
public class RegistrationController {
//    private UserDao userDao;
    @Autowired
    UserService userService;
//    public RegistrationController(UserDao userDao) {
//        this.userDao=userDao;
//    }

    @GetMapping(path = "/add")
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user",user);
        return "register";
    }
    @PostMapping(path ="/add")
    public String add(@Valid @ModelAttribute User user, BindingResult result) {
        if(result.hasErrors() ) {
            return "register";
        }
        userService.saveUser(user);
        return "index";
    }
}

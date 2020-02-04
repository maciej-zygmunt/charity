package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.dto.UserDto;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.security.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/registration")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService=userService;
    }

    @GetMapping(path = "/add")
    public String getUser(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto",userDto);
        return "register";
    }
    @PostMapping(path ="/add")
    public String saveUser(@Valid @ModelAttribute UserDto userDto, BindingResult result,Model model) {
        if(result.hasErrors() ) {
            return "register";
        }
        User user = userDto.getUser();
        userService.saveUser(user);
        return "index";
    }
}

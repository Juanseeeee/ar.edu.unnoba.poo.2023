package com.example.tp4poo.Controller;


import com.example.tp4poo.model.User;
import com.example.tp4poo.service.UserService;
import org.h2.engine.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/view")
    public String view_users(Model model,Authentication authentication){
        User sessionUser = (User)authentication.getPrincipal();
        model.addAttribute("users",userService.getUsers());
        return "users/view";
    }

    @GetMapping("/new")
    public String new_user(Model model){
        model.addAttribute("user",new User());
        return "users/new";
    }

    @PostMapping("/new")
    public String create_user(@ModelAttribute("user") User user){
        userService.create(user);
        return "redirect:/users/view";
    }


}

package com.polhdez.m13.controllers;

import com.polhdez.m13.models.User;
import com.polhdez.m13.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String getRoot() {
        return "login";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView login(Model model,
                        @RequestParam String username,
                        @RequestParam String password) {
        User user = null;
        ModelAndView control = new ModelAndView("control");
        ModelAndView login = new ModelAndView("login");
        try {
            user = userRepository.findByUsername(username).get(0);
            user.setLogged(true);
            userRepository.save(user);
        }
        catch(Exception e)  {
            login.addObject("message", "Login Failed! Check your password!");
            return login;
        }

        if(user.getPassword().equals(password)) {
            return control;
        }
        else
            return login;
    }
}
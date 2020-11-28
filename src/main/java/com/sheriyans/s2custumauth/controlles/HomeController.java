package com.sheriyans.s2custumauth.controlles;

import com.sheriyans.s2custumauth.model.User;
import com.sheriyans.s2custumauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(){
        return  "home";
    }

    @GetMapping("/register")
    public String register(Model model){
        return  "register";
    }

    @GetMapping("/welcome")
    public String welcome(){
        return  "welcome";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user")User user){
        System.out.print(user.toString());
        User newuser= new User();
        newuser.setUsername(user.getUsername());
        newuser.setEmail(user.getEmail());
        newuser.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(newuser);
        return "redirect:/login";
    }

}

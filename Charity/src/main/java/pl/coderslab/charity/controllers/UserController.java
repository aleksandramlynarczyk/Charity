package pl.coderslab.charity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.util.ParallelSorter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.model.UserCheck;
import pl.coderslab.charity.repository.UserRepository;


import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm(Model model) {
        UserCheck userCheck = new UserCheck();
        model.addAttribute("userCheck", userCheck);
        return "register-form";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String performRegisterForm(@Valid @ModelAttribute UserCheck userCheck, BindingResult result) {

        if(!userCheck.getPassword().equals(userCheck.getPassword2())) {
           result.rejectValue("password",null,"Hasła są różne");
            return "register-form";
        }
        String encodedPassword = passwordEncoder.encode(userCheck.getPassword());
        userCheck.setPassword(encodedPassword);
        if (result.hasErrors()) {
            return "register-form";
        }
        User user= new User();
        user.setEmail(userCheck.getEmail());
        user.setPassword(userCheck.getPassword());
        user.setRole("USER");
        user.setFirstName(userCheck.getFirstName());
        user.setLastName(userCheck.getLastName());
        userRepository.save(user);
        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login-form";
    }


}

package dev.abhishek.mvc.controllers;

import dev.abhishek.mvc.models.User;
import dev.abhishek.mvc.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/")
    public String viewUser(Model model){
        List<User> users = (List<User>) userRepository.findAll();
        model.addAttribute("users", users);
        return "view-user";
    }

    @GetMapping(path="/add-user")
    public String returnAddUserPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add-user";
    }

    @PostMapping(path="/add-user")
    public String addNewUser(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "redirect:/add-user";
    }

    @PostMapping("/delete-user")
    public String deleteUser(@RequestParam("id") Integer id, Model model) {
        userRepository.deleteById(id);
        model.addAttribute("users", userRepository.findAll());
        return "redirect:/";
    }
}
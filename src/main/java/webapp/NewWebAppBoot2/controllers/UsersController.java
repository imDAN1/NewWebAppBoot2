package webapp.NewWebAppBoot2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import webapp.NewWebAppBoot2.model.User;
import webapp.NewWebAppBoot2.service.UserService;

@Controller
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users/allUsers";
    }

    @GetMapping("users/new")
    public String createUser(@ModelAttribute("user") User user){
//        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userService.createUser(user);

        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(Model model,@PathVariable("id") Long id) {
        model.addAttribute("user", userService.readUser(id));

        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String printUsers(Model model) {
        List<User> users = userService.getUsersList();
        for(User user:users){
            System.out.println(user);
        }
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping(value = "/addUser")
    public String addUser(Model model, @RequestParam(defaultValue = "0") Long id) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping
    public String addUser(
            @RequestParam String name,
            @RequestParam String lastName
    ) {
        userService.saveUser(name, lastName);
        return "redirect:/";
    }
}

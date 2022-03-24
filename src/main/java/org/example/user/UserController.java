package org.example.user;

import org.example.insurance.Insurance;
import org.example.insurance.InsuranceService;
import org.example.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private ProductService productService;


    @GetMapping("/users")
    public String showUserList (Model model) {
        List<User> listUsers = userService.listAllUsers();
        model.addAttribute("listUsers", listUsers); // in view we can access this list collection to display
        return "users";
    }

    @GetMapping("/users/new")
    public String showNewUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user_form";
    }

    @PostMapping("/users/save")
    public String saveNewUser(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{userId}")
    public String editUserForm(@PathVariable("userId") Long userId, Model model) {
            User user = userService.get(userId);
            model.addAttribute("user", user);

            return "user_edit_form";
    }

    @GetMapping("/users/view/{userId}")
    public String viewUser(@PathVariable("userId") Long userId, Model model) {
            User user = userService.get(userId);
            model.addAttribute("user", user);
            return "user_view";
    }

    @GetMapping("/users/delete/{userId}")
    public String deleteUserForm(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
        return "redirect:/users";
    }
}

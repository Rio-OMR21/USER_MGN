package com.orinaryaga.ManageUserWeb.controller;

import com.orinaryaga.ManageUserWeb.domain.User;
import com.orinaryaga.ManageUserWeb.repository.UserRepository;
import com.orinaryaga.ManageUserWeb.service.UserNotFoundException;
import com.orinaryaga.ManageUserWeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private UserService service;

    @GetMapping("")
    public String viewHomePage(Model model) {
        List<User> listuser = service.listAll();
        model.addAttribute("ListUsers", listuser);
        System.out.println("Get /");
        return "index";
    }

    @GetMapping("users")
    public String showUserlist(Model model) {
        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }

    @GetMapping("/users/new")
    public String showNewForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "ADD NEW USER");
        return "new";
    }

    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes ra) {
        service.save(user);
        ra.addFlashAttribute("message","The user has been added successfuly.");
        return "redirect:/users";
    }

    @GetMapping("users/edit/{id}")
    public String showEditUserPage(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try{
            User user = service.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User(ID:"+ id + ")");
            return "new";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/users";
        }
    }

    @GetMapping("users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra) throws UserNotFoundException {
        service.delete(id);
        return "redirect:/users";
    }



    

}

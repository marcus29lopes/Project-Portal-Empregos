
package com.marcus.jobportal.controller;

import com.marcus.jobportal.entity.Users;
import com.marcus.jobportal.entity.UsersType;
import com.marcus.jobportal.services.UsersService;
import com.marcus.jobportal.services.UsersTypeService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {
    private final UsersTypeService usersTypeService;
    private final UsersService usersService;

    @Autowired
    public UsersController(UsersTypeService usersTypeService, UsersService usersService) {
        this.usersTypeService = usersTypeService;
        this.usersService = usersService;
    }

    @GetMapping({"/register"})
    public String register(Model model) {
        List<UsersType> usersTypes = this.usersTypeService.getAll();
        model.addAttribute("getAllTypes", usersTypes);
        model.addAttribute("user", new Users());
        return "register";
    }

    @PostMapping({"/register/new"})
    public String userRegistration(@Valid Users users) {
        this.usersService.addNew(users);
        return "dashboard";
    }
}
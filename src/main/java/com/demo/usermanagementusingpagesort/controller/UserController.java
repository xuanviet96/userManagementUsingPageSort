package com.demo.usermanagementusingpagesort.controller;

import com.demo.usermanagementusingpagesort.entity.User;

import com.demo.usermanagementusingpagesort.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("users", userService.findAll());
        return "list";
    }

    @GetMapping("list/search")
    public String search(@RequestParam("term") String term, Model model){
        if(StringUtils.isEmpty(term)){
            return "redirect:users/list";
        }
        model.addAttribute("users", userService.search(term));
        return "form";
    }

    @GetMapping("/list/add")
    public String add(Model model){
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/list/save")
    public String save(@Valid User user, BindingResult result, RedirectAttributes redirect){
        if(result.hasErrors()){
            return "form";
        }
        userService.save(user);
        redirect.addFlashAttribute("successMessage", "Saved user successfully!");
        return "redirect:/users/list";
    }
    @GetMapping("/list/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model){
        model.addAttribute("user", userService.findOne(id));
        return "form";
    }



}

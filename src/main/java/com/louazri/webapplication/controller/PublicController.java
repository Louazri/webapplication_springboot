package com.louazri.webapplication.controller;


import com.louazri.webapplication.model.Person;
import com.louazri.webapplication.repository.PersonRepository;
import com.louazri.webapplication.service.PersonService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private PersonService personService;

    @GetMapping("/register")
    public String displayRegisterPage(Model model) {
        model.addAttribute("person", new Person());
        return "register";
    }

    @PostMapping("/createUser")
    public String createUser(@Valid @ModelAttribute("person") Person person, Errors errors) {
        if (errors.hasErrors()) {
            return "register";
        }
        boolean isCreated = personService.createNewPerson(person);
        if (isCreated) {
            return "redirect:/login?register=true";
        } else {
            return "register";
        }
    }
}

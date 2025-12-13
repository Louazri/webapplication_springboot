package com.louazri.webapplication.controller;

import com.louazri.webapplication.model.Contact;
import com.louazri.webapplication.service.ContactService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
@Slf4j
@Controller
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }


    @RequestMapping("/contact")
    public String displayContactPage(Model module) {
        module.addAttribute("contact" , new Contact());
        return "contact";
    }

    @RequestMapping(value = "/saveMsg" , method = POST )
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact , Errors errors) {
        if (errors.hasErrors()) {
            log.error("Contact form validation failed dui to " +errors.toString());
            return "contact.html";
        }
        contactService.saveMessageDetail(contact);
        return "redirect:/contact";
    }

    @RequestMapping("/displayMessages")
    public ModelAndView displayMessages(Model model) {
        List<Contact> contactMsgs = contactService.findMsgsWithOpenStatus();
        ModelAndView modelAndView = new ModelAndView("messages.html");
        modelAndView.addObject("contactMsgs",contactMsgs);
        return modelAndView;
    }

    @RequestMapping(value="/closeMsg" , method = GET)
    public String closeMsg(@RequestParam int id ) {
        contactService.updateMsgStatus(id);
        return "redirect:/displayMessages";
    }

}

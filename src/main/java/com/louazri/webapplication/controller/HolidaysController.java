package com.louazri.webapplication.controller;

import com.louazri.webapplication.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.louazri.webapplication.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidaysController {

    @Autowired
    private HolidayRepository holidayRepository;

    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model) {
        List<Holiday> holidays = holidayRepository.findAllHolidays();

        List<Holiday> national = holidays.stream()
                .filter(h -> h.getType() == Holiday.Type.NATIONAL)
                .collect(Collectors.toList());

        List<Holiday> religious = holidays.stream()
                .filter(h -> h.getType() == Holiday.Type.RELIGIOUS)
                .collect(Collectors.toList());

        if ("all".equalsIgnoreCase(display)) {
            model.addAttribute("NATIONAL", national);
            model.addAttribute("RELIGIOUS", religious);
        } else if ("NATIONAL".equalsIgnoreCase(display)) {
            model.addAttribute("NATIONAL", national);
        } else if ("RELIGIOUS".equalsIgnoreCase(display)) {
            model.addAttribute("RELIGIOUS", religious);
        }

        return "holidays";
    }
}

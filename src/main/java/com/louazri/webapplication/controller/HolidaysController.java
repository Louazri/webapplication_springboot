package com.louazri.webapplication.controller;

import com.louazri.webapplication.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.louazri.webapplication.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class HolidaysController {

    @Autowired
    private HolidayRepository holidayRepository;

    @GetMapping("/holidays/{display}")
    public String displayHolidays(@PathVariable String display, Model model) {
        Iterable<Holiday> holidays = holidayRepository.findAll();
        List<Holiday> holidayList = StreamSupport.stream(holidays.spliterator(), false)
                .collect(Collectors.toList());

        List<Holiday> national = holidayList.stream()
                .filter(h -> h.getType() == Holiday.Type.NATIONAL)
                .collect(Collectors.toList());

        List<Holiday> religious = holidayList.stream()
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

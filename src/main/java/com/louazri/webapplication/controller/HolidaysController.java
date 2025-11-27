package com.louazri.webapplication.controller;

import org.springframework.ui.Model;
import com.louazri.webapplication.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidaysController {

    @GetMapping("/holidays")
    public String displayHolidays(Model model) {
        List<Holiday> holidays = List.of(
                new Holiday("Jan 1", "New Year's Day", Holiday.Type.NATIONAL),
                new Holiday("Jan 11", "Proclamation of Independence", Holiday.Type.NATIONAL),
                new Holiday("May 1", "Labour Day", Holiday.Type.NATIONAL),
                new Holiday("Jul 30", "Throne Day", Holiday.Type.NATIONAL),
                new Holiday("Aug 14", "Oued Ed-Dahab Day", Holiday.Type.NATIONAL),
                new Holiday("Aug 20", "Revolution of the King and the People", Holiday.Type.NATIONAL),
                new Holiday("Aug 21", "Youth Day", Holiday.Type.NATIONAL),
                new Holiday("Nov 6", "Green March", Holiday.Type.NATIONAL),
                new Holiday("Nov 18", "Independence Day", Holiday.Type.NATIONAL),

                // Islamic Holidays (floating dates)
                new Holiday("Variable", "Eid al-Fitr", Holiday.Type.RELIGIOUS),
                new Holiday("Variable", "Eid al-Adha", Holiday.Type.RELIGIOUS),
                new Holiday("Variable", "Aashura", Holiday.Type.RELIGIOUS),
                new Holiday("Variable", "Mawlid (Prophet's Birthday)", Holiday.Type.RELIGIOUS)
        );
        Holiday.Type[] types = Holiday.Type.values();
        for(Holiday.Type type : types) {
            model.addAttribute(
                    type.toString(),
                    holidays.stream()
                            .filter(holiday -> holiday.getType().equals(type))
                            .collect(Collectors.toList())
            );

        }
        return "holidays";
    }
}

package org.springframework.social.showcase.google;

import javax.inject.Inject;

import org.springframework.social.google.api.Google;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoogleCalendarController
{
    private final Google google;

    @Inject
    public GoogleCalendarController(Google google) {
        this.google = google;
    }

    @RequestMapping(value="/google/calendar", method= RequestMethod.GET)
    public String showCalendar(Model model) {
        model.addAttribute("calendar", google.calendarOperations().calendarListQuery());
        return "google/calendar";
    }

}

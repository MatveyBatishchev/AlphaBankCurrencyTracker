package ru.alphabank.currency_tracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.alphabank.currency_tracker.services.GifService;

@Controller
@RequestMapping("/gif")
public class GifController {

    private final GifService gifService;

    @Autowired
    public GifController(GifService currencyTrackerService) {
        this.gifService = currencyTrackerService;
    }

    @GetMapping(value = "/currency-rate/dynamics", produces = "text/html")
    public ModelAndView getCurrencyDynamicsGif(@RequestParam("curr_code") String currencyCode, ModelAndView modelAndView) {
        modelAndView.setViewName("/resultPage");
        modelAndView.addObject("gif", gifService.getCurrencyTrack(currencyCode));
        return modelAndView;
    }

}

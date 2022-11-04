package com.example.WeatherApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.WeatherApp.service.JsonParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@Controller
public class WeatherController {
    @Autowired
    private JsonParsingService jsonParsingService;
    @GetMapping(value = "/main.html")
    public String weatherStat(Model model) {
        model.addAttribute("warm", String.format("%.2f", (((BigDecimal)jsonParsingService.getWeather().getJSONObject("main").get("temp")).doubleValue() - 273.15)));
        return "main";
    }
}

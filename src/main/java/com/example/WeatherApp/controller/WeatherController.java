package com.example.WeatherApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.WeatherApp.service.JsonParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Controller
public class WeatherController {
    @Autowired
    private JsonParsingService jsonParsingService;

//    @GetMapping(value = "/temp")
//    public String drain() {
//        return jsonParsingService.getWeather().getJSONObject("main").get("temp").toString();
//    }
    @GetMapping(value = "/main")
    public String weatherStat(Model model) {
        model.addAttribute("temp", String.format("%.2f", (((BigDecimal)jsonParsingService.getWeather().getJSONObject("main").get("temp")).doubleValue() - 273.15)));
        return "main";
    }
}

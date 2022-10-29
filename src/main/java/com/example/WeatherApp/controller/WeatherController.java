package com.example.WeatherApp.controller;

import org.springframework.ui.Model;
import com.example.WeatherApp.service.JsonParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    @Autowired
    private JsonParsingService jsonParsingService;

    @GetMapping(value = "/temp")
    public String drain() {
        return jsonParsingService.getWeather().getJSONObject("main").get("temp").toString();
    }
    @GetMapping(value = "/test")
    public String main(final Model model) {
        return "Test";
    }
}

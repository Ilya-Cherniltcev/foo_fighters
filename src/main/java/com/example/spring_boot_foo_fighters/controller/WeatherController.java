package com.example.spring_boot_foo_fighters.controller;

import com.example.spring_boot_foo_fighters.client.dto.WeatherResponse;
import com.example.spring_boot_foo_fighters.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam String city) {
        WeatherResponse response = weatherService.getWeather(city);
        return ResponseEntity.ok(response);
    }
}

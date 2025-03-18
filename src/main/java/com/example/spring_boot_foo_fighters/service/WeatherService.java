package com.example.spring_boot_foo_fighters.service;

import com.example.spring_boot_foo_fighters.client.WeatherClient;
import com.example.spring_boot_foo_fighters.client.dto.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {
    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final WeatherClient weatherClient;

    public WeatherResponse getWeather(String city) {
        return weatherClient.getWeatherByCity(city, apiKey, "metric");
    }
}

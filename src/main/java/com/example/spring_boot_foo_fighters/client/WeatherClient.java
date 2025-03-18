package com.example.spring_boot_foo_fighters.client;

import com.example.spring_boot_foo_fighters.client.dto.WeatherResponse;
import com.example.spring_boot_foo_fighters.config.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "weatherClient", url = "https://api.openweathermap.org/data/2.5"
,configuration = FeignClientConfiguration.class)
public interface WeatherClient {

    @GetMapping("/weather")
    WeatherResponse getWeatherByCity(@RequestParam("q") String city,
                                     @RequestParam("appid") String apiKey,
                                     @RequestParam("units") String units);
}
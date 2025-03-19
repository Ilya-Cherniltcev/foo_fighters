package com.example.spring_boot_foo_fighters.client.dto;

import java.util.List;

public class WeatherResponse {
    private Main main;
    private List<Weather> weather;
    // Getters and setters

    public static class Main {
        private double temp;
        private int humidity;
        // Getters and setters
    }

    public static class Weather {
        private String description;
        // Getters and setters
    }
}

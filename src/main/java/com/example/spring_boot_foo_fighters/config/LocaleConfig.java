package com.example.spring_boot_foo_fighters.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.Locale;

@Configuration
public class LocaleConfig {

    private static final Locale AZ = new Locale("az");
    private static final Locale RU = new Locale("ru");
    private static final Locale KZ = new Locale("kz");
    private static final Locale EN = new Locale("en");

    @Bean
    public LocaleResolver localeResolver() {
        var localeResolver = new AcceptHeaderLocaleResolver();
        localeResolver.setDefaultLocale(EN);
        localeResolver.setSupportedLocales(Arrays.asList(AZ, KZ, RU));
        return localeResolver;
    }

}

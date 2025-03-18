package com.example.spring_boot_foo_fighters.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.ResourceBundle;

@AllArgsConstructor
@Getter
public enum MultiLang {

    TEXT("wording.mail.text");

    private final String message;

    public String message() {
        return ResourceBundle.getBundle("i18n/wording/messages",
                LocaleContextHolder.getLocale())
                .getString(this.message);
    }

}

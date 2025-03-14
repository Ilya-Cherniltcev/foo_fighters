package com.example.spring_boot_foo_fighters.service;

import com.example.spring_boot_foo_fighters.client.MailSenderClient;
import com.example.spring_boot_foo_fighters.client.dto.MailRequest;
import com.example.spring_boot_foo_fighters.enumeration.MultiLang;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final MailSenderClient mailSenderClient;

    public void sendMail(MailRequest mailRequest) {
        mailRequest.setText(MultiLang.TEXT.message());
        mailSenderClient.sendMail(mailRequest);
    }

}

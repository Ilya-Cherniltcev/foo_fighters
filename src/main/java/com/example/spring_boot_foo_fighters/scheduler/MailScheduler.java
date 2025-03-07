//package com.example.spring_boot_foo_fighters.scheduler;
//
//import com.example.spring_boot_foo_fighters.client.dto.EmployeeDto;
//import com.example.spring_boot_foo_fighters.client.dto.MailRequest;
//import com.example.spring_boot_foo_fighters.service.MailService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class MailScheduler {
//
//    private final MailService mailService;
//
//    @Scheduled(fixedDelayString = "0 9 * * 1")
//    public void sendMailAllUsers(){
//        MailRequest mailRequest= MailRequest.builder()
//                .mailTo("gunayhashim56@gmail.com")
//                .text("My First Scheduler Message !!!!!")
//                .subject("URGENT!")
//                .employeeDto(EmployeeDto.builder()
//                        .id(4L)
//                        .name("Ruslan")
//                        .surname("Sharovatov")
//                        .build())
//                .build();
//
//        mailService.sendMail(mailRequest);
//        log.info("Mail is sended !!!!!!!");
//    }
//
//}

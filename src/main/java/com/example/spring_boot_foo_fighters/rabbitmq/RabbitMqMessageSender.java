//package com.example.spring_boot_foo_fighters.rabbitmq;
//
//import com.example.spring_boot_foo_fighters.dto.UserDto;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class RabbitMqMessageSender {
//
//    private final RabbitTemplate rabbitTemplate;
//
//    @Bean
//    public Queue queue() {
//        return new Queue("myQueue", false);
//    }
//
//    public void send(UserDto userDto) {
//        rabbitTemplate.convertAndSend("myQueue", userDto);
//        log.info("Sent : {}", userDto);
//    }
//
//}

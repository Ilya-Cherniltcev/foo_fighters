package com.example.spring_boot_foo_fighters.service;

import com.example.spring_boot_foo_fighters.dto.UserDto;
import com.example.spring_boot_foo_fighters.entity.UserEntity;
import com.example.spring_boot_foo_fighters.mapper.UserMapper;
import com.example.spring_boot_foo_fighters.rabbitmq.RabbitMqMessageSender;
import com.example.spring_boot_foo_fighters.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RabbitMqMessageSender rabbitMqMessageSender;

    public UserEntity save(UserDto userDto) {
        rabbitMqMessageSender.send(userDto);
        return userRepository.save(userMapper.toUserEntity(userDto));

    }

}

package com.example.spring_boot_foo_fighters;

import com.example.spring_boot_foo_fighters.dto.UserDto;
import com.example.spring_boot_foo_fighters.entity.UserEntity;
import com.example.spring_boot_foo_fighters.mapper.UserMapper;
import com.example.spring_boot_foo_fighters.repository.UserRepository;
import com.example.spring_boot_foo_fighters.service.UserService;
import org.apache.catalina.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    private static UserDto userDto;

    @Spy
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void init(){
        userDto = new UserDto();
    }

    @Test
    void save_IfAgeGreaterThan20_ReturnUser() {
        userDto.setAge(30);

        UserEntity userEntity = new UserEntity();

//        when(userMapper.toUserEntity(userDto)).thenReturn(userEntity);
        when(userRepository.save(userEntity)).thenReturn(userEntity);

        UserEntity actual = userService.save(userDto);

        Assertions.assertEquals(userEntity, actual);
    }

    @Test
    void save_IfAgeLessThan20_ThrowException() {
        userDto.setAge(15);

        Assertions.assertThrows(IllegalArgumentException.class, () -> userService.save(userDto));
    }

}

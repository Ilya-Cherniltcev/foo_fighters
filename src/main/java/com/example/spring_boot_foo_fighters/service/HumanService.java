package com.example.spring_boot_foo_fighters.service;

import com.example.spring_boot_foo_fighters.dto.HumanDto;
import com.example.spring_boot_foo_fighters.dto.UserDto;
import com.example.spring_boot_foo_fighters.entity.HumanEntity;
import com.example.spring_boot_foo_fighters.mapper.HumanMapper;
import com.example.spring_boot_foo_fighters.rabbitmq.RabbitMqMessageSender;
import com.example.spring_boot_foo_fighters.repository.HumanRepository;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class HumanService {

  private final HumanRepository humanRepository;
  private final HumanMapper humanMapper;

  public List<HumanDto> getHumans() {
    return humanMapper.toHumanDtoList(humanRepository.findAll());
  }

  public HumanDto getHumanById(Long id) {
    if (id != null) {
      HumanEntity humanEntity =
              humanRepository.findById(id)
                      .orElseThrow(() -> new RuntimeException("Human not found"));
      return humanMapper.toHumanDto(humanEntity);
    }
    return null;
  }

  public void saveHuman(HumanDto humanDto) {
    humanRepository.save(humanMapper.toHumanEntity(humanDto));
  }

  public void deleteHumanById(Long id) {
    humanRepository.deleteById(id);
  }

  public List<HumanEntity> getHumansByAge(Integer age) {
    return humanRepository.getHumanEntitiesByAgeIsLessThan(age);
  }

  public void updateById(Long id, HumanDto humanDto) {
    HumanEntity humanEntity = humanMapper.toHumanEntity(getHumanById(id));

    humanEntity.setId(id);
    humanEntity.setCreatedAt(humanEntity.getCreatedAt());
    humanEntity.setName(humanDto.getName());
    humanEntity.setAge(humanDto.getAge());

    humanRepository.save(humanEntity);
  }

}

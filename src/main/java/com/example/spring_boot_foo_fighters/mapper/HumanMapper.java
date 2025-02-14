package com.example.spring_boot_foo_fighters.mapper;

import com.example.spring_boot_foo_fighters.dto.HumanDto;
import com.example.spring_boot_foo_fighters.entity.HumanEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class HumanMapper {

  public HumanEntity toHumanEntity(HumanDto humandDto) {
    HumanEntity humanEntity = new HumanEntity();

    humanEntity.setAge(humandDto.getAge());
    humanEntity.setName(humandDto.getName());

    return humanEntity;
  }

  public HumanDto toHumanDto(HumanEntity humanEntity) {
    HumanDto humanDto = new HumanDto();
    humanDto.setAge(humanEntity.getAge());
    humanDto.setName(humanEntity.getName());

    return humanDto;
  }

  public List<HumanDto> toHumanDtoList(List<HumanEntity> humanEntities) {
    return humanEntities.stream()
            .map(source -> new HumanDto(source.getName(), source.getAge()))
            .collect(Collectors.toList());
  }

}

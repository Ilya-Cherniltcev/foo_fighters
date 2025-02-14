package com.example.spring_boot_foo_fighters.controller;

import com.example.spring_boot_foo_fighters.dto.HumanDto;
import com.example.spring_boot_foo_fighters.entity.HumanEntity;
import com.example.spring_boot_foo_fighters.service.HumanService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @ResponseBody + @Controller
@RequiredArgsConstructor
@RequestMapping("/humans")
public class HumanController {

  private final HumanService humanService;

  @GetMapping
  public List<HumanDto> getAllHumans() {
    return humanService.getHumans();
  }

  @GetMapping("/{id}")
  public HumanDto getHumanById(@PathVariable Long id) {
    return humanService.getHumanById(id);
  }

  @PostMapping
  public void saveHuman(@RequestBody HumanDto humanDto) {
    humanService.saveHuman(humanDto);
  }

  @DeleteMapping("/{id}")
  public void deleteHumanById(@PathVariable Long id) {
    humanService.deleteHumanById(id);
  }

  @GetMapping("/age/{age}")
  public List<HumanEntity> getHumansByAge(@PathVariable Integer age) {
    return humanService.getHumansByAge(age);
  }

  @PutMapping("/{id}")
  public void updateById(@PathVariable Long id, @RequestBody HumanDto humanDto) {
    humanService.updateById(id, humanDto);
  }

}

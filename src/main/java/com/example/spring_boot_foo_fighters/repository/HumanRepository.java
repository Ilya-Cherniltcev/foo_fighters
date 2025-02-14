package com.example.spring_boot_foo_fighters.repository;

import com.example.spring_boot_foo_fighters.entity.HumanEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepository extends JpaRepository<HumanEntity, Long> {

  List<HumanEntity> getHumanEntitiesByAgeIsLessThan(Integer age);

//  select h1_0.id,h1_0.age,h1_0.created_at,h1_0.name,h1_0.updated_at
//  from humans h1_0
//  where h1_0.age<?

}


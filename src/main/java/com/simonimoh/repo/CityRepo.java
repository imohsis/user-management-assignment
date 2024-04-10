package com.simonimoh.repo;

import com.simonimoh.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepo extends JpaRepository<CityEntity, Long> {
    List<CityEntity> findByState_StateId(Long sid);

}


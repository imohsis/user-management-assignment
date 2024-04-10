package com.simonimoh.repo;

import com.simonimoh.entity.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepo extends JpaRepository<StateEntity, Long> {

    List<StateEntity> findByCountry_CountryId(Long countryId);
}


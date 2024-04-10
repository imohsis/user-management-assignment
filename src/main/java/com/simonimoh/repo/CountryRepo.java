package com.simonimoh.repo;

import com.simonimoh.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<CountryEntity, Long> {
}

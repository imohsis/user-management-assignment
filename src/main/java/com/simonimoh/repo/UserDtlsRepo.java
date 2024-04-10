package com.simonimoh.repo;

import com.simonimoh.dto.UserDto;
import com.simonimoh.entity.UserDtlsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDtlsRepo extends JpaRepository<UserDtlsEntity, Long> {
    boolean existsByEmail(String email);

    UserDtlsEntity findByEmail(String email);

    UserDto findByEmailAndPassword(String email, String password);
}

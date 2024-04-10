package com.simonimoh.service;

import com.simonimoh.dto.LoginDto;
import com.simonimoh.dto.RegisterDto;
import com.simonimoh.dto.ResetPwdDto;
import com.simonimoh.dto.UserDto;
import com.simonimoh.entity.UserDtlsEntity;

import java.util.Map;

public interface UserService {

    public Map<Long, String> getCountries();

    public Map<Long, String> getStates(Long cid);

    public Map<Long, String> getCities(Long sid);

    public String registerUser(RegisterDto registerDto);

    public UserDtlsEntity getUserByEmail(String email);

    public UserDto getUser(LoginDto loginDto);

    public boolean resetPassword(ResetPwdDto resetPwdDto, String email);

    public String getQuote(); //api call



}

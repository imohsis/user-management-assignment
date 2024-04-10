package com.simonimoh.service;

import com.simonimoh.dto.LoginDto;
import com.simonimoh.dto.RegisterDto;
import com.simonimoh.dto.ResetPwdDto;
import com.simonimoh.dto.UserDto;
import com.simonimoh.entity.CityEntity;
import com.simonimoh.entity.CountryEntity;
import com.simonimoh.entity.StateEntity;
import com.simonimoh.entity.UserDtlsEntity;
import com.simonimoh.repo.CityRepo;
import com.simonimoh.repo.CountryRepo;
import com.simonimoh.repo.StateRepo;
import com.simonimoh.repo.UserDtlsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDtlsRepo userDtlsRepo;

    @Autowired
    private CountryRepo countryRepo;

    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private StateRepo stateRepo;

    public Map<Long, String> getCountries() {
        List<CountryEntity> countries = countryRepo.findAll();
        Map<Long, String> countryMap = new HashMap<>();
        for (CountryEntity country : countries) {
            countryMap.put(country.getCountryId(), country.getCountryName());
        }
        return countryMap;
    }

    @Override
    public Map<Long, String> getStates(Long cid) {
        List<StateEntity> states = stateRepo.findByCountry_CountryId(cid);
        Map<Long, String> stateMap = new HashMap<>();
        for (StateEntity state : states) {
            stateMap.put(state.getStateId(), state.getStateName());
        }
        return stateMap;
    }

    @Override
    public Map<Long, String> getCities(Long sid) {
        List<CityEntity> cities = cityRepo.findByState_StateId(sid);
        Map<Long, String> cityMap = new HashMap<>();
        for (CityEntity city : cities) {
            cityMap.put(city.getCityId(), city.getCityName());
        }
        return cityMap;
    }


    @Override
    public String registerUser(RegisterDto registerDto) {
        if (userDtlsRepo.existsByEmail(registerDto.getEmail())) {
            return "Email is already registered";
        }else{
            String password = generateRandomPassword();

            UserDtlsEntity user = new UserDtlsEntity();
            user.setName(registerDto.getName());
            user.setEmail(registerDto.getEmail());
            user.setPassword(password);
            user.setPhoneNumber(registerDto.getPhoneNumber());
            user.setPasswordUpdated("no");

            user.setCountry(registerDto.getCountry());
            user.setState(registerDto.getState());
            user.setCity(registerDto.getCity());

            userDtlsRepo.save(user);
//            send email here after saving

            return "User registered successfully. Temporary password: " + password;
        }
    }

    @Override
    public UserDtlsEntity getUserByEmail(String email) {
        return userDtlsRepo.findByEmail(email);
    }

    @Override
    public UserDto getUser(LoginDto loginDto) {
        return userDtlsRepo.findByEmailAndPassword(loginDto.getEmail(),loginDto.getPassword());
    }

    @Override
    public boolean resetPassword(ResetPwdDto resetPwdDto, String email) {

        UserDtlsEntity user = userDtlsRepo.findByEmail(email);
        if (user == null) {
            return false;
        }

        if (!resetPwdDto.getOldPassword().equals(user.getPassword())) {
            return false;
        }

        if (!resetPwdDto.getNewPassword().equals(resetPwdDto.getConfirmPassword())) {
            return false;
        }

        user.setPassword(resetPwdDto.getNewPassword());
        userDtlsRepo.save(user);

        return true;

    }

    @Override
    public String getQuote() {
        return null;
    }



    private String generateRandomPassword() {
        String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(5);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            sb.append(alphanumeric.charAt(random.nextInt(alphanumeric.length())));
        }
        return sb.toString();
    }
}

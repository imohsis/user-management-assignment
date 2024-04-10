package com.simonimoh.controller;

import com.simonimoh.dto.LoginDto;
import com.simonimoh.dto.RegisterDto;
import com.simonimoh.dto.ResetPwdDto;
import com.simonimoh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerPage(Model model){

        return "registration";

    }

    @GetMapping("/states/{cid}")

    public Map<Integer, String> getStates(@PathVariable("cid") Integer cid){

        return null;

    }
    @GetMapping("/cities/{sid}")
    public Map<Integer, String> getCities(@PathVariable("csid")Integer sid){

        return null;
    }

    @PostMapping("/register")
    public String register(RegisterDto registerDto){
        return null;

    }

    public String loginPage(Model model){
        return null;

    }

    public String login(LoginDto loginDto, Model model){
        return null;

    }

    public String resetPwd(ResetPwdDto resetPwdDto, Model model){
        return null;

    }
    public String dashboard(Model model){
        return null;

    }


    public String logout(){
        return null;

    }


}

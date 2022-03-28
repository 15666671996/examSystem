package com.gcse.gcse_math.controller;

import com.gcse.gcse_math.entity.User;
import com.gcse.gcse_math.service.Auth_Service_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;

@RestController
public class Auth_Controller {
    @Autowired
    private Auth_Service_Interface service;

    @RequestMapping("/login")
    public HashMap<String, Object> login(String email, String password) {
        return service.login(new User(email,password));
    }




    @RequestMapping("/checkUserName")
    public HashMap<String, Object> checkUserName(String email) {

        return null;
    }

}

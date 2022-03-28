package com.gcse.gcse_math.service;

import com.gcse.gcse_math.entity.User;
import com.gcse.gcse_math.repository.Auth_Repository_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Objects;

@Service
public class Auth_Service implements Auth_Service_Interface {

    @Autowired
    private Auth_Repository_Interface repository;

    @Override
    public HashMap<String, Object> login(User user) {
        HashMap<String, Object> rtn = repository.login(user);
        if ((boolean) rtn.get("status")) {
            HttpSession session = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
            session.setAttribute("currentUser", user.getEmail());
        }
        return rtn;
    }
}

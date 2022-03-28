package com.gcse.gcse_math.repository;

import com.gcse.gcse_math.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


@Repository
public class Auth_Repository implements Auth_Repository_Interface {

    @Autowired
    private JdbcTemplate template;

    @Override
    public HashMap<String, Object> login(User user) {
        HashMap<String, Object> rtn = new HashMap<>();
        try {
            String sql = "select COUNT(*) from user where email='" + user.getEmail() + "' and password='" + user.getPassword() + "'";
            int result = template.queryForObject(sql, Integer.class);
            if (result > 0) {
                rtn.put("status", true);
            } else {
                rtn.put("status", false);
                rtn.put("message", "email or password not correct");
            }
        } catch (DataAccessException e) {
            rtn.put("status", false);
            rtn.put("message", "server exception");
            System.out.println(e.getMessage());
        }
        return rtn;
    }

    @Override
    public HashMap<String, Object> checkUserName(String email) {
        HashMap<String, Object> rtn = new HashMap<>();
        try {
            String sql = "select COUNT(*) from user where email='" + email + "'";
            int result = template.queryForObject(sql, Integer.class);
            if (result == 0) {
                rtn.put("status", true);
            } else {
                rtn.put("status", false);
            }
        } catch (DataAccessException e) {
            rtn.put("status", false);
            rtn.put("message", "server exception");
            System.out.println(e.getMessage());
        }
        return rtn;
    }

}

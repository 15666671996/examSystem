package com.gcse.gcse_math.repository;

import com.gcse.gcse_math.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class Auth_Repository implements Auth_Repository_Interface {

    @Autowired
    private JdbcTemplate template;

    @Override
    public HashMap<String, Object> login(User user) {
        HashMap<String, Object> rtn = new HashMap<>();
        try {
            String sql = "select * from user where email=? and password=?";
            List<Map<String, Object>> result = template.queryForList(sql, user.getEmail(), user.getPassword());
            if (result.size() > 0) {
                rtn.put("status", "success");
                rtn.put("permissionLevel",result.get(0).get("level"));
            } else {
                rtn.put("status", "failed");
                rtn.put("message", "email or password not correct");
            }
        } catch (DataAccessException e) {
            rtn.put("status", "exception");
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
                rtn.put("status", "available");
            } else {
                rtn.put("status", "unavailable");
            }
        } catch (DataAccessException e) {
            rtn.put("status", "exception");
            rtn.put("message", "server exception");
            System.out.println(e.getMessage());
        }
        return rtn;
    }

}

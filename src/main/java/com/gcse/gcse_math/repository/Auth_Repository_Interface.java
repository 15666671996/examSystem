package com.gcse.gcse_math.repository;

import com.gcse.gcse_math.entity.User;
import java.util.HashMap;

public interface Auth_Repository_Interface {
    HashMap<String, Object> login(User user);

    HashMap<String, Object> checkUserName(String email);
}

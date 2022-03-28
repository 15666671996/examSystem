package com.gcse.gcse_math.service;

import com.gcse.gcse_math.entity.User;
import java.util.HashMap;

public interface Auth_Service_Interface {
    HashMap<String, Object> login(User user);
}

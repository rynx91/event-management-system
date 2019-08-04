package com.joyce.sample.service;

import com.joyce.sample.entity.UserBean;

import java.util.Map;

public interface UserService {

    public Map<String,String> loginUser(UserBean userBean);

    public Map<String, String> createUser(UserBean userBean);
}

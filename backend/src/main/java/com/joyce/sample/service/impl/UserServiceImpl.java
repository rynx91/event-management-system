package com.joyce.sample.service.impl;

import com.joyce.sample.entity.UserBean;
import com.joyce.sample.repository.UserRepository;
import com.joyce.sample.service.UserService;
import com.joyce.sample.util.CryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public Map<String,String> loginUser(UserBean userBean) {
        Map<String, String> result = new HashMap<>();
        if(userBean !=null){
            UserBean m = userRepository.getByUserId("joyce");
            if(m!=null){
                if(userBean.getFailedLogin()>=3){
                    result.put("error", "You have failed to login 3 times. Kindly contact IT admin to unlock your account.");
                }
                else{
                    try{
                        CryptUtil cryptUtil = new CryptUtil();
                        String decryptedPassword = cryptUtil.decrypt(m.getPassword());
                        if(userBean.getPassword().equals(decryptedPassword)){
                            m.setFailedLogin(0);
                            m.setLastLoginDate(new Date());
                            userRepository.save(m);
                            result.put("userId", m.getUserId());
                        }else{
                            result.put("error", "User id or password is incorrect");
                        }
                    }catch(Exception e){
                        result.put("error","Something went wrong.");
                    }
                }
            }
        }
        return result;
    }

    @Override
    public Map<String, String> createUser(UserBean userBean) {
        Map<String, String> result = new HashMap<>();
        try {
            UserBean  existingUserBean = userRepository.getByUserId(userBean.getUserId());
            if(existingUserBean!=null){
                result.put("error", "User ID has already been registered.");
            }else {
                CryptUtil cryptutil = new CryptUtil();
                String encryptedPassword = cryptutil.encrypt(userBean.getPassword());
                userBean.setPassword(encryptedPassword);
                userBean.setFailedLogin(0);
                userBean.setLastLoginDate(new Date());
                userRepository.save(userBean);
                result.put("success", "You have successfuly signed up. Please proceed to login");
            }
        }catch(Exception e){
            e.printStackTrace();
            result.put("error", "Sign up failed!");
        }
        return result;
    }
}

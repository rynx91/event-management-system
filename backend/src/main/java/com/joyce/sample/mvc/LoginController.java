package com.joyce.sample.mvc;

import com.joyce.sample.entity.UserBean;
import com.joyce.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/login"})
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Map<String,String> loginMember(@RequestBody UserBean userBean){
        return userService.loginUser(userBean);
    }

}

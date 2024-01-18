package com.siemens.controller;



import com.siemens.entity.UserInfo;
import com.siemens.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class RegistrationController {

    @Autowired
    private UserService service;



    @PostMapping("/registration")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return service.addUser(userInfo);
    }


}

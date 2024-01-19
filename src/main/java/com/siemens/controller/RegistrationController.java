package com.siemens.controller;



import com.siemens.dto.ResponseHandler;
import com.siemens.dto.UserDto;
import com.siemens.entity.UserInfo;
import com.siemens.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class RegistrationController {

    @Autowired
    private UserService userService;



    /*@PostMapping("/registration")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return service.addUser(userInfo);
    }*/

    @PostMapping(value = "/registration")
    public ResponseEntity<Object> addNewUser(@RequestBody UserInfo userInfo) {
        try {
            List<UserInfo> existingUser = userService.findUserByEmail(userInfo.getEmail());
            List<UserInfo> user =  existingUser.stream().filter(e->e.getEmail().equals(userInfo.getEmail())).collect(Collectors.toList());
            if (!user.isEmpty()) {
                return ResponseHandler.generateResponse("User Email already registered !!!", HttpStatus.OK, user);
            }
            UserInfo result = userService.addUser(userInfo);
            return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }




}

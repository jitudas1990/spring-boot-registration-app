package com.siemens.service;


import com.siemens.entity.UserInfo;
import com.siemens.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public List<UserInfo> findUserByEmail(String email) {
        return repository.findAll();
    }

    public UserInfo addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        return repository.save(userInfo);
    }
}

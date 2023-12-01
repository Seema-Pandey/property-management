package com.company.Property.Management.service.impl;

import com.company.Property.Management.converter.UserConverter;
import com.company.Property.Management.entity.UserEntity;
import com.company.Property.Management.model.UserModel;
import com.company.Property.Management.repository.UserRepository;
import com.company.Property.Management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserModel registerUser(UserModel userModel) {
        UserEntity userInfo=userConverter.convertModelToEntity(userModel);
        userInfo=userRepository.save(userInfo);
        userModel=userConverter.convertEntityToModel(userInfo);
        return userModel;
    }

    @Override
    public UserModel userLogin(String userEmail, String userPassword) {
        return null;
    }
}

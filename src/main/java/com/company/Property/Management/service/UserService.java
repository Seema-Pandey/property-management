package com.company.Property.Management.service;

import com.company.Property.Management.model.UserModel;

public interface UserService {

    UserModel registerUser(UserModel userModel);
    UserModel userLogin(String userEmail,String userPassword);
}

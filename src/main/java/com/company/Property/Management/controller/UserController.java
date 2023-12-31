package com.company.Property.Management.controller;

import com.company.Property.Management.model.UserModel;
import com.company.Property.Management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<UserModel> registerUser(@RequestBody UserModel userModel){
        userModel=userService.registerUser(userModel);
        ResponseEntity<UserModel> responseEntity=new ResponseEntity<>(userModel, HttpStatus.CREATED);
        return responseEntity;
    }

    @PostMapping("/login")
    public ResponseEntity<UserModel> loginUser(@RequestBody UserModel userModel){
        userModel=userService.userLogin(userModel.getPropertyOwnerEmail(),userModel.getUserPassword());
        ResponseEntity<UserModel> responseEntity=new ResponseEntity<>(userModel, HttpStatus.OK);
        return responseEntity;
    }
}

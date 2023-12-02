package com.company.Property.Management.service.impl;

import com.company.Property.Management.converter.UserConverter;
import com.company.Property.Management.entity.UserEntity;
import com.company.Property.Management.exception.BusinessException;
import com.company.Property.Management.exception.ErrorModel;
import com.company.Property.Management.model.UserModel;
import com.company.Property.Management.repository.UserRepository;
import com.company.Property.Management.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserModel registerUser(UserModel userModel) {
        Optional<UserEntity> ownerEmail=userRepository.findByPropertyOwnerEmail(userModel.getPropertyOwnerEmail());
        if(ownerEmail.isPresent()){
            List<ErrorModel> errorModelList=new ArrayList<>();
            ErrorModel errorModel=new ErrorModel();
            errorModel.setErrorCode("EMAIL_ALREADY_EXISTS");
            errorModel.setErrorMessage("this email already exists in our system,please login with with your email and password directly");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        UserEntity userInfo=userConverter.convertModelToEntity(userModel);
        userInfo=userRepository.save(userInfo);
        userModel=userConverter.convertEntityToModel(userInfo);
        return userModel;

    }

    @Override
    public UserModel userLogin(String userEmail, String userPassword) {
        UserModel userModel=null;
        Optional<UserEntity> userInfoFromRepository=userRepository.findByPropertyOwnerEmailAndUserPassword(userEmail,userPassword);

        if(userInfoFromRepository.isPresent()){
            userModel=userConverter.convertEntityToModel(userInfoFromRepository.get());
        }else{
            List<ErrorModel> errorModelList=new ArrayList<>();
            ErrorModel errorModel=new ErrorModel();
            errorModel.setErrorCode("INVALID LOGIN");
            errorModel.setErrorMessage("Incorrect user email or password");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        return userModel;
    }
}

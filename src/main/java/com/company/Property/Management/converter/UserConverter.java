package com.company.Property.Management.converter;

import com.company.Property.Management.entity.UserEntity;
import com.company.Property.Management.model.UserModel;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertModelToEntity(UserModel userModel){
        UserEntity userEntity=new UserEntity();
        userEntity.setPropertyOwnerName(userModel.getPropertyOwnerName());
        userEntity.setPropertyOwnerEmail(userModel.getPropertyOwnerEmail());
        userEntity.setUserPhoneNumber(userModel.getUserPhoneNumber());
        userEntity.setUserPassword(userModel.getUserPassword());
        return userEntity;
    }

    public UserModel convertEntityToModel(UserEntity userEntity){
        UserModel userModel=new UserModel();
        userModel.setId(userEntity.getId());
        userModel.setPropertyOwnerName(userEntity.getPropertyOwnerName());
        userModel.setPropertyOwnerEmail(userEntity.getPropertyOwnerEmail());
        userModel.setUserPhoneNumber(userEntity.getUserPhoneNumber());
        return userModel;
    }
}

package com.company.Property.Management.repository;

import com.company.Property.Management.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {

    Optional<UserEntity> findByPropertyOwnerEmailAndUserPassword(String email,String password);

    Optional<UserEntity> findByPropertyOwnerEmail(String email);

}

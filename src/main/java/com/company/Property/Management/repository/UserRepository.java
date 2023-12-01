package com.company.Property.Management.repository;

import com.company.Property.Management.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {


}

package com.company.Property.Management.repository;

import com.company.Property.Management.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {


}

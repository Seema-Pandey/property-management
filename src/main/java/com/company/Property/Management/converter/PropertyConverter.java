package com.company.Property.Management.converter;

import com.company.Property.Management.entity.PropertyEntity;
import com.company.Property.Management.model.PropertyModel;
import org.springframework.stereotype.Component;

@Component
public class PropertyConverter {

    public PropertyEntity convertModelToEntity(PropertyModel propertyModel){
        PropertyEntity propertyEntity=new PropertyEntity();
        propertyEntity.setPropertyName(propertyModel.getPropertyName());
        propertyEntity.setPropertyDescription(propertyModel.getPropertyDescription());
        propertyEntity.setPropertyPrice(propertyModel.getPropertyPrice());
        propertyEntity.setPropertyAddress(propertyModel.getPropertyAddress());
        return propertyEntity;
    }

    public PropertyModel convertEntityToModel(PropertyEntity propertyEntity){
        PropertyModel propertyModel=new PropertyModel();
        propertyModel.setId(propertyEntity.getId());
        propertyModel.setPropertyName(propertyEntity.getPropertyName());
        propertyModel.setPropertyDescription(propertyEntity.getPropertyDescription());
        propertyModel.setPropertyPrice(propertyEntity.getPropertyPrice());
        propertyModel.setPropertyAddress(propertyEntity.getPropertyAddress());
        return propertyModel;
    }
}

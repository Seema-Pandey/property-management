package com.company.Property.Management.service;

import com.company.Property.Management.model.PropertyModel;

import java.util.List;

public interface PropertyService {
     PropertyModel addNewProperty(PropertyModel propertyModel);
     List<PropertyModel> getAllProperties();
     PropertyModel updateProperty(PropertyModel propertyModel,Long propertyId);
     PropertyModel updatePropertyDescription(PropertyModel propertyModel,Long propertyId);
     PropertyModel updatePropertyPrice(PropertyModel propertyModel,Long propertyId);
     void deleteProperty(Long property);
}


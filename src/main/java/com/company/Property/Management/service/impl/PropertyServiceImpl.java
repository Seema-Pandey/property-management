package com.company.Property.Management.service.impl;

import com.company.Property.Management.converter.PropertyConverter;
import com.company.Property.Management.entity.PropertyEntity;
import com.company.Property.Management.model.PropertyModel;
import com.company.Property.Management.repository.PropertyRepository;
import com.company.Property.Management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyModel addNewProperty(PropertyModel propertyModel) {
        PropertyEntity propertyEntity=propertyConverter.convertModelToEntity(propertyModel);
        propertyEntity=propertyRepository.save(propertyEntity);
        PropertyModel propertyModel1=propertyConverter.convertEntityToModel(propertyEntity);
        return propertyModel1;
    }

    @Override
    public List<PropertyModel> getAllProperties() {
        List<PropertyEntity> listOfProperties= (List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyModel> propertyModelList=new ArrayList<>();
        //we need to convert from entity to model
        for(PropertyEntity eachEntity:listOfProperties){
            PropertyModel eachModel=propertyConverter.convertEntityToModel(eachEntity);
            propertyModelList.add(eachModel);
        }
        return propertyModelList;
    }

    //updating the entire property contents by id if the entry is present
    @Override
    public PropertyModel updateProperty(PropertyModel propertyModel, Long propertyId) {
        Optional<PropertyEntity> entityOutput=propertyRepository.findById(propertyId);
        PropertyModel propertyDTO=null;
        if(entityOutput.isPresent()){
            PropertyEntity entity=entityOutput.get(); //data from database
            //overiding all values
            entity.setPropertyName(propertyModel.getPropertyName());
            entity.setPropertyDescription(propertyModel.getPropertyDescription());
            entity.setPropertyPrice(propertyModel.getPropertyPrice());
            entity.setPropertyAddress(propertyModel.getPropertyAddress());
            propertyDTO=propertyConverter.convertEntityToModel(entity);
            propertyRepository.save(entity);
        }
        return propertyDTO;
    }

    @Override
    public PropertyModel updatePropertyDescription(PropertyModel propertyModel, Long propertyId) {
        Optional<PropertyEntity> entityOutput=propertyRepository.findById(propertyId);
        PropertyModel propertyDTO=null;
        if(entityOutput.isPresent()){
            PropertyEntity entity=entityOutput.get(); //data from database
            entity.setPropertyDescription(propertyModel.getPropertyDescription());
            propertyDTO=propertyConverter.convertEntityToModel(entity);
            propertyRepository.save(entity);
        }
        return propertyDTO;
    }

    @Override
    public PropertyModel updatePropertyPrice(PropertyModel propertyModel, Long propertyId) {
        Optional<PropertyEntity> entityOutput=propertyRepository.findById(propertyId);
        PropertyModel propertyDTO=null;
        if(entityOutput.isPresent()){
            PropertyEntity entity=entityOutput.get(); //data from database
            entity.setPropertyPrice(propertyModel.getPropertyPrice());
            propertyDTO=propertyConverter.convertEntityToModel(entity);
            propertyRepository.save(entity);
        }
        return propertyDTO;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }
}

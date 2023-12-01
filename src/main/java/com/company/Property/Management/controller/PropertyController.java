package com.company.Property.Management.controller;

import com.company.Property.Management.model.PropertyModel;
import com.company.Property.Management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Value("${propdb.dummy}")
    private String whichEnv;

    @Value("${spring.datasource.driverClassName}")
    private String driverName;
   @Autowired
    private PropertyService propertyService;

    @PostMapping("/addProperty")
    public ResponseEntity<PropertyModel> addNewProperty(@RequestBody PropertyModel propertyModel){
        propertyModel=propertyService.addNewProperty(propertyModel);
        ResponseEntity<PropertyModel> responseEntity=new ResponseEntity<>(propertyModel, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/getProperties")
    public ResponseEntity<List<PropertyModel>> getAllProperties(){
        System.out.println(whichEnv);
        System.out.println(driverName);
       List<PropertyModel> propertyList= propertyService.getAllProperties();
       ResponseEntity<List<PropertyModel>> responseEntity=new ResponseEntity<>(propertyList,HttpStatus.OK);
        return responseEntity;
    }


    @PutMapping("/getProperties/{propertyId}")
    public ResponseEntity<PropertyModel> updateProperty(@RequestBody PropertyModel propertyModel, @PathVariable Long propertyId){
        propertyModel= propertyService.updateProperty(propertyModel,propertyId);
        ResponseEntity<PropertyModel> responseEntity=new ResponseEntity<>(propertyModel, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/getProperties/update-description/{propertyId}")
    public ResponseEntity<PropertyModel> updatePropertyDescription(@RequestBody PropertyModel propertyModel,@PathVariable Long propertyId){
        propertyModel= propertyService.updatePropertyDescription(propertyModel,propertyId);
        ResponseEntity<PropertyModel> responseEntity=new ResponseEntity<>(propertyModel, HttpStatus.OK);
        return responseEntity;
    }

    @PatchMapping("/getProperties/update-price/{propertyId}")
    public ResponseEntity<PropertyModel> updatePropertyPrice(@RequestBody PropertyModel propertyModel,@PathVariable Long propertyId){
        propertyModel= propertyService.updatePropertyPrice(propertyModel,propertyId);
        ResponseEntity<PropertyModel> responseEntity=new ResponseEntity<>(propertyModel, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/getProperties/{propertyId}")
    public void deleteProperty(@PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);

    }
}

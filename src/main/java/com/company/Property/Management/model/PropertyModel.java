package com.company.Property.Management.model;

import lombok.Data;

@Data
public class PropertyModel {
    private Long id;
    private String  propertyName;
    private String propertyDescription;
    private String propertyOwnerName;
    private String propertyOwnerEmail;
    private Double propertyPrice;
    private String propertyAddress;
}


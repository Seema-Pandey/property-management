package com.company.Property.Management.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name="propertyTable")
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   // @Column(name="propertyTitle",nullable = false)
    private String  propertyName;
    private String propertyDescription;
    private Double propertyPrice;
    private String propertyAddress;
}

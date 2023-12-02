package com.company.Property.Management.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class BusinessException extends RuntimeException{
    private List<ErrorModel> errorModelList;
    public BusinessException(List<ErrorModel> errorModelList){
        this.errorModelList=errorModelList;
    }
}

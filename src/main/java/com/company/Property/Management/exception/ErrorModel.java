package com.company.Property.Management.exception;

import lombok.Data;

@Data
public class ErrorModel {
    private String errorCode;
    private String errorMessage;
}

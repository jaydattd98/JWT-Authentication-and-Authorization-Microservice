package com.cognizant.springboot.jwtauthentication.exception;

public class ErrorInfo {

    private String errorCode;
    private String description;

    public ErrorInfo(ErrorCode errorCode) {
        this.errorCode = errorCode.getCode();
        this.description = errorCode.getDescription();
    }

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "errorCode='" + errorCode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

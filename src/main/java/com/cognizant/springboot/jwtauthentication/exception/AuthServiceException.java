package com.cognizant.springboot.jwtauthentication.exception;

public class AuthServiceException extends Exception {

    private ErrorCode errorCode;

    public AuthServiceException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}

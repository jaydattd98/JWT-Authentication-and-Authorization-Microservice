package com.cognizant.springboot.jwtauthentication.exception;

public enum ErrorCode {

    INVALID_INPUT("400", "J001", "provided input are not valid, please check the input"),
    INVALID_USER_CREDENTIAL("403", "J002", "provided user credentials are not valid, please check the again"),
    DATA_NOT_FOUND("404", "J003", "Response is null for your request"),
    UNAUTHORIZED("401", "J004", "You are not allowed to this service"),
    USER_NAME_NOT_FOUND_EXCEPTION("404", "J005", "User credential are not matching, no data found in DB"),
    INTERNAL_SERVER_EXCEPTION("00", "J006", "Something went wrong while authenticating user details,Please try again");

    private String status;
    private String code;
    private String description;

    ErrorCode(String status, String code, String description) {
        this.status = status;
        this.code = code;
        this.description = description;
    }

    ErrorCode() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "status='" + status + '\'' +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

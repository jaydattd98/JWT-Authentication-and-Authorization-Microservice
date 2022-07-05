package com.cognizant.springboot.jwtauthentication.exception;

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class AuthExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AuthServiceException.class)
    public ResponseEntity<ErrorInfo> handelUserException(AuthServiceException e) {
        return new ResponseEntity<ErrorInfo>(new ErrorInfo(e.getErrorCode()), getHttpStatus(e.getErrorCode().getStatus()));
    }

    @ExceptionHandler(InternalException.class)
    public ResponseEntity<ErrorInfo> handelUserException(InternalException e) {
        return new ResponseEntity<ErrorInfo>(new ErrorInfo(ErrorCode.INTERNAL_SERVER_EXCEPTION), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private HttpStatus getHttpStatus(String status) {
        switch (status) {
            case "400":
                return HttpStatus.BAD_REQUEST;
            case "401":
                return HttpStatus.UNAUTHORIZED;
            case "403":
                return HttpStatus.FORBIDDEN;
            case "404":
                return HttpStatus.NOT_FOUND;
            default:
                return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }
}

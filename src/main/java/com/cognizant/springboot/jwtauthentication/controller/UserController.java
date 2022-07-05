package com.cognizant.springboot.jwtauthentication.controller;

import com.cognizant.springboot.jwtauthentication.exception.AuthServiceException;
import com.cognizant.springboot.jwtauthentication.exception.ErrorCode;
import com.cognizant.springboot.jwtauthentication.model.User;
import com.cognizant.springboot.jwtauthentication.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * Class UserController
 *
 * @author jaydatt
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/auth/v1")
@AllArgsConstructor
public class UserController {

    private UserRepository userRepository;

    /**
     * Used to create user Account
     *
     * @param user
     * @return ResponseEntity<User>
     */
    @PostMapping(value = "/create", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> createUser(@RequestBody User user) throws AuthServiceException {
        validateUserDetails(user);
        return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);
    }

    /**
     * @param user
     * @return validR
     */
    private void validateUserDetails(User user) throws AuthServiceException {
        if (user == null || !StringUtils.hasText(user.getUserName()) || !StringUtils.hasText(user.getPassword())
                || !StringUtils.hasText(user.getPhoneNumber())) {
            log.error("Validation failed for Request input -> user =" + user.toString());
            throw new AuthServiceException(ErrorCode.INVALID_INPUT);
        }
    }
}

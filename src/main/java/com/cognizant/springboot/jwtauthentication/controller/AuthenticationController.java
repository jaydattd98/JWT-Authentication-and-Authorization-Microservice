package com.cognizant.springboot.jwtauthentication.controller;

import com.cognizant.springboot.jwtauthentication.exception.AuthServiceException;
import com.cognizant.springboot.jwtauthentication.exception.ErrorCode;
import com.cognizant.springboot.jwtauthentication.helper.JwtUtil;
import com.cognizant.springboot.jwtauthentication.model.JwtRequest;
import com.cognizant.springboot.jwtauthentication.model.JwtResponse;
import com.cognizant.springboot.jwtauthentication.service.MyUserDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

/**
 * Class AuthenticationController
 * Used to provide the Auth service api
 *
 * @author jaydatt
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/auth/v1")
@AllArgsConstructor
public class AuthenticationController {

    private MyUserDetailsService myUserDetailsService;
    private JwtUtil jwtUtil;
    private AuthenticationManager authenticationManager;

    /**
     * API used to login user and create token for him
     *
     * @param jwtRequest
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest jwtRequest) throws AuthServiceException {
        String methodName = "AuthenticationController#generateToken";
        log.info("inside the " + methodName);
        try {
            authenticationManager.
                    authenticate(new UsernamePasswordAuthenticationToken
                            (jwtRequest.getUsername(), jwtRequest.getPassword()));
        } catch (UsernameNotFoundException e) {
            log.error("Exception occurred in " + methodName + "Exception= " + e.getStackTrace());
            throw new AuthServiceException(ErrorCode.USER_NAME_NOT_FOUND_EXCEPTION);
        } catch (BadCredentialsException e) {
            log.error("Exception occurred in " + methodName + "Exception= " + e.getStackTrace());
            throw new AuthServiceException(ErrorCode.INVALID_USER_CREDENTIAL);
        }
        UserDetails userDetails = myUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = jwtUtil.generateToken(userDetails);
        log.info("End the " + methodName + " Got token =" + token);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    /**
     * API used to validate user token given by him
     * if we get respose 200 OK from this API we can say used token is valid
     * As we are validating it in filter
     *
     * @return ResponseEntity<Boolean>
     */
    @GetMapping("/isTokenValid")
    public ResponseEntity<Boolean> isTokenValid() {
        String methodName = "AuthenticationController#isTokenValid";
        log.info("inside the " + methodName);
        log.info("Provided Token is Valid returning true");
        return ResponseEntity.ok(true);
    }
}

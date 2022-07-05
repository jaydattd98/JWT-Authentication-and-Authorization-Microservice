package com.cognizant.springboot.jwtauthentication.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

public class JwtResponse {

    private String token;
}

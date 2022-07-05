package com.cognizant.springboot.jwtauthentication.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class User {
    @Id
    private String userName;
    private String password;
    private String phoneNumber;
}

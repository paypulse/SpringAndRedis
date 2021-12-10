package com.example.redis.model;



import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
public class User implements Serializable {

     private Long id;
     private String userId;
     private String password;
     private String email;

}

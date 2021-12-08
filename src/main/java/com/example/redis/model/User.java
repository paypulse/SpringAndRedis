package com.example.redis.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@RedisHash("user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    private Long id;

    /** 사용자 id로 사용자 정보를 조회 **/
    @Indexed
    private String userId;

    private String password;
    private String email;

    public User(String userId, String password, String email){
        this.userId =  userId;
        this.password = password;
        this.email = email;

    }

}

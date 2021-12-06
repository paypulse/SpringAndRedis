package com.example.redis.Domain;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.logging.Level;

@Getter
@Setter
public class User implements Serializable {

    @NotNull
    String name;
    int id;

    Level level;


}

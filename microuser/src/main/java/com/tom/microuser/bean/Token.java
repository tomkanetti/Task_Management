package com.tom.microuser.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
public class Token {
    @Id
    @JsonIgnore
    String id;
    String userName;
    String token;


    public Token(String userName, String token) {
        this.userName=userName;
        this.token=token;
    }
}

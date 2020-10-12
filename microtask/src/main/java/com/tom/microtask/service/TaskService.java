package com.tom.microtask.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TaskService {

    @Autowired
    RestTemplate restTemplate;

    public boolean checkIfUserExists(String userName) {
        return restTemplate.postForObject("http://localhost:1234/v1/user/checkIfExists",userName,Boolean.class);
    }
}

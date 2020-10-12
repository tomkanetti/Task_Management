package com.tom.microuser.api;

import com.tom.microuser.bean.Token;
import com.tom.microuser.bean.User;
import com.tom.microuser.controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("v1/user")
public class UserApi {

    @Autowired
    UserController userController;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        userController.register(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public  ResponseEntity<?> login(@RequestParam("User Name") String name, @RequestParam("Password") String password) throws Exception {
        Token t=userController.login(name, password);
        HttpHeaders headers = new HttpHeaders();
        headers.add("token",t.getToken());
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @PostMapping("/checkIfExists")
    public ResponseEntity<Boolean> checkIfUserExistsByName(@RequestBody String userName) throws Exception {
        userController.checkIfUserExists(userName);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

}

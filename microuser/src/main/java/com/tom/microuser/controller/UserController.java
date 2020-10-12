package com.tom.microuser.controller;

import com.tom.microuser.bean.Token;
import com.tom.microuser.bean.User;
import com.tom.microuser.dao.TokenRepository;
import com.tom.microuser.dao.UserRepository;
import com.tom.microuser.exception.MicroUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class UserController {
//    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
//            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    @Autowired
    UserRepository userRepository;
    @Autowired
    TokenRepository tokenRepository;

    public void checkIfUserExists(String userName) throws Exception {
        User u = userRepository.findByUserName(userName);
        if (u == null)
            throw new MicroUserException("User not exists", HttpStatus.NOT_FOUND);
    }


    public void register(User user) {
        userRepository.save(user);
    }

//    private  boolean checkEmail(String email){
//        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
//        return matcher.find();
//    }

    public Token login(String name, String password) throws Exception {
        User user = userRepository.login(name, password);
        if (user != null) {
            Token t = new Token(user.getUserName(), UUID.randomUUID().toString());
            tokenRepository.save(t);
            return t;
        } else throw new MicroUserException("User not found",HttpStatus.NOT_FOUND);
    }
}

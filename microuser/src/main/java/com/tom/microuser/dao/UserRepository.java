package com.tom.microuser.dao;

import com.tom.microuser.bean.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<User,String> {

    User findByUserName(String name);
    @Query("{ 'userName' : ?0 , 'password': ?1}")
    User login(String name, String password);

}

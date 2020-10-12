package com.tom.microuser.dao;

import com.tom.microuser.bean.Token;
import com.tom.microuser.bean.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TokenRepository extends MongoRepository<Token,String> {



}

package com.bridgelabz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.yaml.snakeyaml.tokens.Token.ID;

import com.bridgelabz.model.User;

public interface UserMongoRepository extends MongoRepository<User, ID>{

}

package com.bridgelabz.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.bridgelabz.model.User;

@Repository
public interface UserMongoRepository extends MongoRepository<User, String>{

	
}

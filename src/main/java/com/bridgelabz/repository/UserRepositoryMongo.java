 
package com.bridgelabz.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.bridgelabz.model.User;

public class UserRepositoryMongo implements UserRepository {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		return mongoTemplate.findOne(query, User.class);
	}

	@Override
	public boolean regUser(User user) {
		// TODO Auto-generated method stub
		mongoTemplate.save(user);
		return true;
	}

}

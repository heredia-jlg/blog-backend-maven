package com.jlgh.blog.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.jlgh.blog.entities.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositories extends MongoRepository<User, String> {
}

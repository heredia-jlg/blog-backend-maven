package com.jlgh.blog.repositories;
import com.jlgh.blog.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends MongoRepository<Post, String>{

}

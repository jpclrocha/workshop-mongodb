package com.jopezin.workshopmongodb.repositories;

import com.jopezin.workshopmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}

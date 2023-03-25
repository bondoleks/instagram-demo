package com.instagramdemo.instagramDemo.repo;

import com.instagramdemo.instagramDemo.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
    Optional<Post> findByUsername(String username);

}

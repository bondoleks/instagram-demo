package com.instagramdemo.instagramDemo.repo;

import com.instagramdemo.instagramDemo.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}

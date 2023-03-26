//package com.instagramdemo.instagramDemo.service;
//
//import com.instagramdemo.instagramDemo.model.Post;
//import com.instagramdemo.instagramDemo.repo.PostRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class PostService {
//
//    private final PostRepository repo;
//
//    public Optional<Post> findById(Long id) {
//        return repo.findById(id);
//    }
//
//    public Iterable<Post> findAll(){
//        return repo.findAll();
//    }
//
//    public void save(Post post){
//        repo.save(post);
//    }
//
//    public boolean existsById(Long id){
//        return repo.existsById(id);
//    }
//
//}

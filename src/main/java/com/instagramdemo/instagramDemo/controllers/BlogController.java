package com.instagramdemo.instagramDemo.controllers;


import com.instagramdemo.instagramDemo.model.Post;
import com.instagramdemo.instagramDemo.repo.PostRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Controller
public class BlogController {

    private final static String cookieName = "CookieTest";

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/home")
    public String home(Model model){
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "home";
    }

    @GetMapping("/message")
    public String message(Model model){
        return "message";
    }

    @GetMapping("/likes")
    public String likes(Model model){
        return "likes";
    }

    @GetMapping("/registration")
    public String registration(HttpServletResponse rs, Model model){
        rs.addCookie(new Cookie(cookieName, UUID.randomUUID().toString()));
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationForm(@RequestParam(required = false) String enter, @RequestParam String login, @RequestParam String password, Model model){
        Post post = new Post(login, password);
        if(enter != null){
            for(Post x : postRepository.findAll()){
                if (x.getLogin().equals(post.getLogin()) && x.getPassword().equals(post.getPassword()))
                    return "redirect:/profile/" + x.getId();
            }
            return "redirect:/registration";
        }
            postRepository.save(post);
            return "redirect:/profile/" + post.getId();
    }

//    @GetMapping("/profile")
//    public String profile(Model model){
//        return "profile";
//    }

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable(value = "id") long id, Model model){
        if(!postRepository.existsById(id)){
            return "redirect:/registration";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> result = new ArrayList<>();
        post.ifPresent(result::add);
        model.addAttribute("post", result);
        return "profile";
    }
    @PostMapping("/profile/{id}")
    public String addPhoto(@PathVariable(value = "id") long id, @RequestParam(required = false) String add, @RequestParam String photo, Model model){
        Post postPhoto = postRepository.findById(id).get();
        if(add != null && postRepository.existsById(id)){
            postPhoto.setPhotoAlbum(photo);
            postRepository.save(postPhoto);
        }
        return "redirect:/profile/" + id;
    }

//    @GetMapping("/blog/add")
//    public String blogAdd(Model model){
//        return "blog-add";
//    }
//
//    @PostMapping("/blog/add")
//    public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text,  Model model){
//        Post post = new Post(title, anons, full_text);
//        postRepository.save(post);
//        return "redirect:/blog";
//    }
//
//    @GetMapping("/blog/{id}")
//    public String blogDetails(@PathVariable(value = "id") long id, Model model){
//        if(!postRepository.existsById(id)){
//            return "redirect:/blog";
//        }
//        Optional<Post> post = postRepository.findById(id);
//        ArrayList<Post> result = new ArrayList<>();
//        post.ifPresent(result::add);
//        model.addAttribute("post", result);
//        return "blog-details";
//    }
//
//    @GetMapping("/blog/{id}/edit")
//    public String blogEdit(@PathVariable(value = "id") long id, Model model){
//        if(!postRepository.existsById(id)){
//            return "redirect:/blog";
//        }
//        Optional<Post> post = postRepository.findById(id);
//        ArrayList<Post> result = new ArrayList<>();
//        post.ifPresent(result::add);
//        model.addAttribute("post", result);
//        return "blog-edit";
//    }
//
//    @PostMapping("/blog/{id}/edit")
//    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text,  Model model){
//        Post post = postRepository.findById(id).orElseThrow();
//        post.setTitle(title);
//        post.setAnons(anons);
//        post.setFullText(full_text);
//        postRepository.save(post);
//        return "redirect:/blog";
//    }
//
//    @PostMapping("/blog/{id}/remove")
//    public String blogPostDeleted(@PathVariable(value = "id") long id, Model model){
//        Post post = postRepository.findById(id).orElseThrow();
//        postRepository.delete(post);
//        return "redirect:/blog";
//    }
}

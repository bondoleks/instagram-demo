package com.instagramdemo.instagramDemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Entity
@Data
@Table(name = "new")
@NoArgsConstructor

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

//    @Column(name = "photoAvatar")
//    private String photoAvatar;
//    @Column(name = "photoAlbum")
//    private String photoAlbum;

//    @Column(name = "Cookie")
//    private String Cookie;



    public Post(String username, String password) {
        this.username = username;
        this.password = password;
    }
}

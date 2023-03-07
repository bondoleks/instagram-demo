package com.instagramdemo.instagramDemo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    @Column(name = "photoAvatar")
    private String photoAvatar;
    @Column(name = "photoAlbum")
    private String photoAlbum;

    @Column(name = "Cookie")
    private String Cookie;


    public Post() {
    }

    public Post(String login, String password) {
        this.login = login;
        this.password = password;
    }
}

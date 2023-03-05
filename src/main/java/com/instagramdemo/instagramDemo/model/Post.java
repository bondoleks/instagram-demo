package com.instagramdemo.instagramDemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;
    private String password;

    private String photoAvatar;
    private String photoAlbum;

    private String Cookie;


    public Post() {
    }

    public Post(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotoAvatar() {
        return photoAvatar;
    }

    public void setPhotoAvatar(String photoAvatar) {
        this.photoAvatar = photoAvatar;
    }

    public String getPhotoAlbum() {
        return photoAlbum;
    }

    public void setPhotoAlbum(String photoAlbum) {
        this.photoAlbum = photoAlbum;
    }

    public String getCookie() {
        return Cookie;
    }

    public void setCookie(String cookie) {
        Cookie = cookie;
    }
}

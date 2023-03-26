package com.instagramdemo.instagramDemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class DbUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String username;
    String password;

    public DbUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
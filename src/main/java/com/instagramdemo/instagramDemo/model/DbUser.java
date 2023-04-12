package com.instagramdemo.instagramDemo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
public class DbUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String password;
    private String roles;

    private final static String DELIMITER = ":";

    public DbUser(String username, String password, String... roles) {
        this.username = username;
        this.password = password;
        setRoles(roles);
    }

    public String[] getRoles() {
        return Optional.ofNullable(roles)
                .map(x -> x.split(DELIMITER))
                .orElseGet(() -> new String[]{});
    }

    public void setRoles(String[] roles) {
        this.roles = String.join(DELIMITER, roles);
    }

}

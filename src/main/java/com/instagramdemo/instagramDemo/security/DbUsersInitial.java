package com.instagramdemo.instagramDemo.security;

import com.instagramdemo.instagramDemo.model.DbUser;
import com.instagramdemo.instagramDemo.repo.DbUserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
public class DbUsersInitial {

    private final DbUserRepo dbUserRepo;
    private final PasswordEncoder enc;

    public void create(String login, String password) {
        dbUserRepo.saveAll(Arrays.asList(
           new DbUser(login, enc.encode(password))
        ));
    }

}

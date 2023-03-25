package com.instagramdemo.instagramDemo.security;

import com.instagramdemo.instagramDemo.model.Post;
import com.instagramdemo.instagramDemo.repo.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class MyUserDetailsServiceJPA implements UserDetailsService {

    private final PostRepository repo;

    private UserDetails mapper(Post dbUser) {
        return User
                .withUsername(dbUser.getUsername())
                .password(dbUser.getPassword())
                .roles("USER")
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repo.findByUsername(username)
                .map(this::mapper)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("user `%s` not found", username)
                ));
    }

}

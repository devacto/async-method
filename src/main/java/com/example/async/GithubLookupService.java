package com.example.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Future;

@Service
public class GithubLookupService {

    RestTemplate restTemplate = new RestTemplate();

    @Async
    public Future<User> findUser(String user) throws InterruptedException {
        System.out.printf("Looking up %s\n", user);
        User results = restTemplate.getForObject("https://api.github.com/users/" + user, User.class);
        return new AsyncResult<>(results);
    }
}

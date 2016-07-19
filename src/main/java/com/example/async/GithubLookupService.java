package com.example.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class GithubLookupService {

    @Autowired
    GithubClient githubClient;

    @Async
    public Future<User> findUser(String user) throws InterruptedException {
        User results = githubClient.getForObject(user);
        return new AsyncResult<>(results);
    }

}

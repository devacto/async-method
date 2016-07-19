package com.example.async;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class GithubClientImpl implements GithubClient {

    public User getForObject(String user) {
        System.out.printf("Looking up %s\n", user);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://api.github.com/users/" + user, User.class);
    }

    public User recover(HttpClientErrorException exception) {
        System.out.printf("Recovering: %s\n", exception.getMessage());
        return null;
    }
}

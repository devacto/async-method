package com.example.async;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.client.HttpClientErrorException;

interface GithubClient {

    @Retryable(value = HttpClientErrorException.class, maxAttempts = 3)
    User getForObject(String user);

    @Recover
    User recover(HttpClientErrorException exception);
}

package com.example.async;

import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.client.HttpClientErrorException;

interface Client {

    @Retryable(value = HttpClientErrorException.class, maxAttempts = 3)
    User getUser(String user);

    @Recover
    User recover(HttpClientErrorException exception);
}

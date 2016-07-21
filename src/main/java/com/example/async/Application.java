package com.example.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Future;

@EnableCaching
@EnableAsync
@EnableRetry
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    GithubLookupService githubLookupService;

    @Override
    public void run(String... args) throws Exception {

        Future<User> page1 = githubLookupService.findUser("PivotalSoftware");
        System.out.println(page1.get());

        Future<User> page2 = githubLookupService.findUser("PivotalSoftware");
        System.out.println(page2.get());

        Future<User> page3 = githubLookupService.findUser("lkasjdkaslakdjl");
        System.out.println(page3.get());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


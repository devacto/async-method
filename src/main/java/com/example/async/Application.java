package com.example.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Future;

@SpringBootApplication
@EnableAsync
public class Application implements CommandLineRunner{

    @Autowired
    GithubLookupService githubLookupService;

    @Override
    public void run(String... args) throws Exception {

        Future<User> page1 = githubLookupService.findUser("PivotalSoftware");
        Future<User> page2 = githubLookupService.findUser("DiUS");

        System.out.println(page1.get());
        System.out.println(page2.get());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

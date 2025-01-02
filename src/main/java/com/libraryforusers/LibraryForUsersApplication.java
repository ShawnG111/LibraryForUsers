package com.libraryforusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LibraryForUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryForUsersApplication.class, args);
    }

}

package com.yasin.paperlock;

import com.yasin.paperlock.utilities.EnvLoaderUtility;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaperLockApplication {

    public static void main(String[] args) {
        EnvLoaderUtility envLoaderUtility = new EnvLoaderUtility();
        envLoaderUtility.loadIntoSystemProperties();
        SpringApplication.run(PaperLockApplication.class, args);
    }

}

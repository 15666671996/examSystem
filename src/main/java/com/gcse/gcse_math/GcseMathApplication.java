package com.gcse.gcse_math;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class GcseMathApplication {

    public static void main(String[] args) {
        SpringApplication.run(GcseMathApplication.class, args);
    }

}

package com.fpfos.microservice.activity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by Fu Pengfei on 2018/7/31.
 */

@SpringBootApplication
@EnableEurekaClient
public class ActivityApplication {

    public static void main(String[] args) {

        SpringApplication.run(ActivityApplication.class, args);
    }

}

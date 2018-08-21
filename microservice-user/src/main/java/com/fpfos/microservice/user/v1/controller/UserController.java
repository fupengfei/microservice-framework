package com.fpfos.microservice.user.v1.controller;

import com.fpfos.microservice.user.v1.bean.LoginInputBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by Fu Pengfei on 2018/7/24.
 */
@RestController("/v1/")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("loginWithPasswd")
    public Mono<String> loginWithPasswd(LoginInputBean input) {


        return null;
    }

    @GetMapping("loginWithCode")
    public Mono<String> loginWithCode(LoginInputBean input) {


        return null;
    }

    @GetMapping("loginWithOther")
    public Mono<String> loginWithOther(LoginInputBean input) {

        return null;
    }
}

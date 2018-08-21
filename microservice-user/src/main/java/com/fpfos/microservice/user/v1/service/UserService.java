package com.fpfos.microservice.user.v1.service;

import com.fpfos.microservice.user.v1.bean.LoginInputBean;
import com.fpfos.microservice.user.v1.bean.LoginOutputBean;
import reactor.core.publisher.Mono;

/**
 * Created by Fu Pengfei on 2018/8/2.
 */
public interface UserService {

    Mono<LoginOutputBean> login(LoginInputBean input);

    Mono<LoginOutputBean> loginRegistWithSms(LoginInputBean input);
}

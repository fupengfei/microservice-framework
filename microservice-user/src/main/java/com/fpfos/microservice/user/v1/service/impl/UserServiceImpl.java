package com.fpfos.microservice.user.v1.service.impl;

import com.fpfos.common.core.entity.PdUser;
import com.fpfos.common.core.utils.EncryptUtils;
import com.fpfos.common.core.utils.Utils;
import com.fpfos.microservice.user.dao.UserDao;
import com.fpfos.microservice.user.repository.PdUserRepository;
import com.fpfos.microservice.user.v1.bean.LoginInputBean;
import com.fpfos.microservice.user.v1.bean.LoginOutputBean;
import com.fpfos.microservice.user.v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Created by Fu Pengfei on 2018/8/2.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PdUserRepository pdUserRepository;

    @Autowired
    private UserDao userDao;

    @Override
    public Mono<LoginOutputBean> login(LoginInputBean input) {

        PdUser pdUser = pdUserRepository.findByMobile(input.getMobile());
        if (null == pdUser) {
            //
        }

        if(!EncryptUtils.verifyMd5Hex(pdUser.getLoginPasswdSalt(), input.getPasswd(), pdUser.getLoginPasswd())){
            //
        }

        pdUser = userDao.login(pdUser.getPrimaryCode());

        LoginOutputBean output = new LoginOutputBean();
        output.setMobile(pdUser.getMobile());
        output.setToken(Utils.UUID());

        return Mono.just(output);
    }

    @Override
    public Mono<LoginOutputBean> loginRegistWithSms(LoginInputBean input) {


        return null;
    }
}

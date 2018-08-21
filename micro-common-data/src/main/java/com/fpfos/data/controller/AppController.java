package com.fpfos.data.controller;

import com.fpfos.common.core.entity.PdUser;
import com.fpfos.common.core.utils.Utils;
import com.fpfos.data.jparepository.UserJpaRepository;
import com.fpfos.data.redisrepository.UserRedisRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Fu Pengfei on 2018/8/15.
 */
@RestController
@RequestMapping("/app/")
public class AppController {

    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private UserRedisRepository userRedisRepository;


    @GetMapping("hello")
    public String hello() {

        PdUser user = new PdUser();
        user.setPrimaryCode(Utils.UUID());
        user.setNickname("小恩");
        user.setMobile("15721093932");
        user.setCreateDate(System.currentTimeMillis());

        userJpaRepository.save(user);

        userRedisRepository.save(user);

        return "ok";
    }

    @GetMapping("get")
    public String get(int i,String primaryCode) {

        PdUser pdUser = null;
        if(i == 0){

            pdUser = userJpaRepository.findByPrimaryCode(primaryCode);

        }else {

            pdUser = userRedisRepository.findById(primaryCode).get();
        }

        return pdUser.toString();
    }
}

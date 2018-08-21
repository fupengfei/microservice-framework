package com.fpfos.microservice.user.dao;

import com.fpfos.common.core.entity.PdUser;
import com.fpfos.microservice.user.repository.PdUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Fu Pengfei on 2018/8/2.
 */
@Repository
public class UserDao {

    @Autowired
    private PdUserRepository pdUserRepository;

    public PdUser login(String primaryCode){

        PdUser user = pdUserRepository.findByPrimaryCode(primaryCode);



        return user;
    }


}

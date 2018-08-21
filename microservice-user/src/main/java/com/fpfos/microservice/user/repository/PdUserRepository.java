package com.fpfos.microservice.user.repository;

import com.fpfos.common.core.entity.PdUser;
import com.fpfos.common.core.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Fu Pengfei on 2018/8/2.
 */
@Repository
public interface PdUserRepository extends AbstractRepository<PdUser, Integer> {

    PdUser findByMobile(String mobile);
}

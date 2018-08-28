package com.fpfos.data.repositories.jpa;

import com.fpfos.common.core.entity.PdUser;
import com.fpfos.common.core.repository.AbstractJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Fu Pengfei on 2018/8/14.
 */

@Repository
public interface UserJpaRepository extends AbstractJpaRepository<PdUser, Long> {
}

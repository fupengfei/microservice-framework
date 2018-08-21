package com.fpfos.data.redisrepository;

import com.fpfos.common.core.entity.PdUser;
import com.fpfos.common.core.repository.AbstractRedisRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Fu Pengfei on 2018/8/14.
 */

@Repository
public interface UserRedisRepository extends AbstractRedisRepository<PdUser, String> {


}

package com.fpfos.common.core.repository;

import com.fpfos.common.core.entity.core.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by Fu Pengfei on 2018/8/2.
 */
@NoRepositoryBean
public interface AbstractRedisRepository<T extends AbstractEntity, ID> extends CrudRepository<T, ID> {


}

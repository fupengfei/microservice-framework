package com.fpfos.data;

import com.fpfos.data.configure.MyMappingRedisConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.core.convert.MappingRedisConverter;
import org.springframework.data.redis.core.convert.RedisCustomConversions;
import org.springframework.data.redis.core.convert.ReferenceResolver;
import org.springframework.data.redis.core.mapping.RedisMappingContext;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

/**
 * Created by Fu Pengfei on 2018/8/14.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableJpaRepositories(basePackages = "com.fpfos.data.jparepository")
@EnableRedisRepositories(basePackages = "com.fpfos.data.redisrepository")
@EntityScan("com.fpfos.common.core.entity")
@ComponentScan("com.fpfos")
public class DataApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataApplication.class, args);
    }

    @Bean
    public MappingRedisConverter redisConverter(RedisMappingContext mappingContext,
                                                RedisCustomConversions customConversions, ReferenceResolver referenceResolver) {

        MyMappingRedisConverter mappingRedisConverter = new MyMappingRedisConverter(mappingContext, null, referenceResolver);

        return mappingRedisConverter;
    }


}

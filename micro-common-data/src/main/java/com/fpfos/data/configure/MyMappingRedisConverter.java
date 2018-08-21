package com.fpfos.data.configure;

import com.fpfos.common.core.entity.core.RedisMapping;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.data.redis.core.convert.*;
import org.springframework.data.redis.core.mapping.RedisMappingContext;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by Fu Pengfei on 2018/8/21.
 */
public class MyMappingRedisConverter extends MappingRedisConverter {
    /**
     * Creates new {@link MappingRedisConverter} and defaults {@link RedisMappingContext} when {@literal null}.
     *
     * @param mappingContext    can be {@literal null}.
     * @param indexResolver     can be {@literal null}.
     * @param referenceResolver must not be {@literal null}.
     */
    public MyMappingRedisConverter(RedisMappingContext mappingContext, IndexResolver indexResolver, ReferenceResolver referenceResolver) {
        super(mappingContext, indexResolver, referenceResolver);
    }

    @Override
    public void write(Object source, RedisData sink) {

        super.write(source, sink);

        Bucket bucket = sink.getBucket();
        try {
            Class clazz = Class.forName(new String(bucket.get("_class")));

            Field[] superFields = clazz.getSuperclass().getDeclaredFields();
            Field[] childFields = clazz.getDeclaredFields();

            Field[] fields = (Field[]) ArrayUtils.addAll(superFields, childFields);

            for (Field field : fields) {

                Annotation redisMapping = field.getAnnotation(RedisMapping.class);
                if (null == redisMapping) {

                    bucket.remove(field.getName());
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}



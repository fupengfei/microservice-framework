package com.fpfos.common.core.entity.core;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Fu Pengfei on 2018/8/15.
 */

@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface RedisMapping {
}

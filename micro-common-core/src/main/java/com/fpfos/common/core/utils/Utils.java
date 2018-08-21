package com.fpfos.common.core.utils;

import java.util.UUID;

/**
 * Created by Fu Pengfei on 2018/8/3.
 */
public class Utils {

    public static String UUID(){

        return UUID.randomUUID().toString().replace("-","");
    }
}

package com.fpfos.common.core.bean;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Fu Pengfei on 2018/8/2.
 */
public class JsonBaseObject {

    public static Gson GSON = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm")
            .setPrettyPrinting()
            .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
            .create();

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}

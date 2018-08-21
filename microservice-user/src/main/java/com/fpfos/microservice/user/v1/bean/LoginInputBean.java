package com.fpfos.microservice.user.v1.bean;

import com.fpfos.common.core.bean.JsonBaseObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Fu Pengfei on 2018/7/31.
 */
@Setter
@Getter
public class LoginInputBean extends JsonBaseObject {

    private String mobile;

    private String passwd;

    private String SmsCode;

    private String smsToken;

    private String referee;

}

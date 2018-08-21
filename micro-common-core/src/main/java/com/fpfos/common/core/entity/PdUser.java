package com.fpfos.common.core.entity;

import com.fpfos.common.core.entity.core.AbstractEntity;
import com.fpfos.common.core.entity.core.RedisMapping;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.keyvalue.annotation.KeySpace;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;


/**
 * Created by Fu Pengfei on 2018/8/2.
 */

@Getter
@Setter
@RedisHash("rd_user")
@Table(name = "tb_user")
@Entity
public class PdUser extends AbstractEntity {

    @RedisMapping
    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "nickname")
    @RedisMapping
    private String nickname;

    @Column(name = "login_passwd")
    private String loginPasswd;

    @Column(name = "login_passwd_salt")
    private String loginPasswdSalt;

    @RedisMapping
    @Column(name = "email_address")
    private String emailAddress;

    @RedisMapping
    @ManyToOne(targetEntity = PdUser.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "referee",referencedColumnName = "primary_code")
    private PdUser referee;

}

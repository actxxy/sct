package com.xxy.user.pojo;

import com.sun.javafx.beans.IDProperty;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "tb_user")
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String userName;//用户名
    private String password;
    private String name;//姓名
    private Integer age;//年龄
    private Integer sex;//性别,1男性，2女性
    private Date birthday;//出生日期
    private Date created;//创建日期
    private Date updated;//更新日期
    private String note;//备注
}

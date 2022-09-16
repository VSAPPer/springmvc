package com.itheima.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;

@Data
@TableName("tbl_user")
public class User {
    private Long id;
    private String username;
    private String password;
    private String gender;
    private String address;

}

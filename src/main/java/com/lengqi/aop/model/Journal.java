package com.lengqi.aop.model;

import java.util.Date;
import lombok.Data;

@Data
public class Journal {
    /**
    * 日志id
    */
    private Integer id;

    /**
    * 用户id
    */
    private Integer uid;

    /**
    * 模块类型
    */
    private Integer modulartype;

    /**
    * 操作类型：0：增/1：删/2：改/3：关闭/4：移动
    */
    private Integer operationtype;

    /**
    * 操作时间
    */
    private Date operationtime;
}
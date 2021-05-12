package com.lengqi.aop.contant;
/**
 * 静态信息
 * Created by Administrator on 2017/8/12.
 */
public class StaticInfo {
    /**--------------------  模块类型  ----------------*/
    //模块1
    public static final int MODEULARTTYPE_FIRST= 1;

    /**--------------------  操作类别  ---------------*/
    //增加
    public static final int OPERATIONTYPE_ADD = 0;
    //删除
    public static final int OPERATIONTYPE_UPDATE = 1;
    //修改
    public static final int OPERATIONTYPE_DELETE = 2;
    //开启
    public static final int OPERATIONTYPE_OPEN = 3;
    //关闭
    public static final int OPERATIONTYPE_CLOSE = 4;
    //移动
    public static final int OPERATIONTYPE_MOVER = 5;

    /**---------------   AOP代理  --------------------*/
    public static final String AOP_OPERATION_TYPE_ADD =  "add";
    public static final String AOP_OPERATION_TYPE_EDIT =  "edit";
    public static final String AOP_OPERATION_TYPE_MOVE =  "move";
    public static final String AOP_OPERATION_TYPE_DELETE =  "delete";
    public static final String AOP_OPERATION_TYPE_OPENORCLOSE =  "openOrClose";

    public static final String AOP_MODULAR_TYPE_FIRST = "Journal";

    public static final String AOP_SPIT_CLASSNAME = "impl.";
    public static final String AOP_SPIT_MODULAR_TYPE= "ServiceImpl";
}

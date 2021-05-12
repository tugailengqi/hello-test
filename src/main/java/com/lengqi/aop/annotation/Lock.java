package com.lengqi.aop.annotation;

import java.lang.annotation.*;

/**
 * 分布式锁的应用注解
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Lock {
    //分布式锁的key前缀
    String lockName() default "";
    //等待时长
    int waitTime() default 3;

    //有效时长
    int effectiveTime() default 5;
}

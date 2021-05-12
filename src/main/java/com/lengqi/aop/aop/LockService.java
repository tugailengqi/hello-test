package com.lengqi.aop.aop;

import com.lengqi.aop.annotation.Lock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class LockService {
    public static String LOCK_NAME  = "lockName";
    public static String WAIT_TIME = "waitTime";
    public static String EFFECTIVE_TIME = "effectiveTime";

//    @Autowired
//    private RedissonUtil redissonUtil;
    private Logger logger = LoggerFactory.getLogger(LockService.class);

    @Pointcut("@annotation(com.lengqi.aop.annotation.Lock)")
    public void lockPointCut(){}
    @Around("lockPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Map<String, Object> map = getLockParams(point);
        String lockName = (String)map.get(LOCK_NAME);
        int waitTime = (int)map.get(WAIT_TIME);
        int effectiveTime = (int)map.get(EFFECTIVE_TIME);
        Object[] methodParams = null;
        Object object = null;
        boolean resl = false;
        //获取方法参数
        methodParams = point.getArgs();

        String lockKey = (String)methodParams[0];
        //获得锁对象的实例
//        RLock redissonLock = redissonUtil.getRedisson().getLock(lockName+lockKey);

        return null;
    }

    //获取目标方法中的锁参数
    public Map<String,Object> getLockParams(ProceedingJoinPoint point) throws Exception{
        String targetName = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        Object[] args = point.getArgs();

        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        Map<String,Object> map = new HashMap<>();
        for (Method method : methods) {
            if (method.getName().equals(methodName)){
                Lock lock = method.getAnnotation(Lock.class);
                if (lock!=null) {
                    String lockName = lock.lockName();
                    int waitTime = lock.waitTime();
                    int effectiveTime = lock.effectiveTime();
                    map.put(LOCK_NAME,lockName);
                    map.put(WAIT_TIME,waitTime);
                    map.put(EFFECTIVE_TIME,effectiveTime);
                }
                break;
            }
        }
        return map;
    }
}

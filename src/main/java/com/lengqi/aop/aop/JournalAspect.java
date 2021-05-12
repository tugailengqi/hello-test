package com.lengqi.aop.aop;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.lengqi.aop.contant.StaticInfo;
import com.lengqi.aop.util.JournalUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

@Component
@Aspect
public class JournalAspect {

    private static final Logger logger = LoggerFactory.getLogger(JournalAspect.class);

    @Autowired
    private JournalUtil journalUtil;

    /** service切面**/
    private final String POINT_CUT = "execution(* com.lengqi.aop.service..*(..))";

    @Pointcut(POINT_CUT)
    private void pointCut(){}

    /**
     * 后置通知方式（目标方法只要执行完了就会执行后置通知方法）
     * @param joinPoint
     */
    @After(value = "pointCut()")
    @Transactional
    public void doAfterAdvice(JoinPoint joinPoint) throws Exception{
        //用的最多，通知的前面
        Signature signature = joinPoint.getSignature();
        //1.获取模块类型
        //AOP代理类的名字（包括包名）
        String declaringTypeName = signature.getDeclaringTypeName();
        logger.info("AOP代理类的名字"+declaringTypeName);
        //获取代理类的类名
        String[] split = declaringTypeName.split(StaticInfo.AOP_SPIT_CLASSNAME);
        String className = split[1];
       //获取模块名
        String[] modularTypeNames = className.split(StaticInfo.AOP_SPIT_MODULAR_TYPE);
        String modularTypeName  =  modularTypeNames[0];
        int modulerType = -1;
        //模块类型筛选
        modulerType = this.getModularType(modularTypeName, modulerType);

        //2.获取操作类型
        //代理的是哪个方法
        String methodName = signature.getName();
        logger.info("AOP代理方法的名字"+signature.getName());
        int operationType = -1;
        operationType = getOperationType(joinPoint, signature, operationType, methodName);
        if (modulerType == -1 && operationType ==-1 ){
            if (!StrUtil.isBlank(methodName) || !StrUtil.isBlank(modularTypeName)){
                throw new Exception("系统错误");
            }
        }
        //添加日志
        if (modulerType != -1 && operationType != -1){
            //TODO 3.1从请求中获取用户id
            journalUtil.addJournalInfo(modulerType,operationType,10086);
        }
    }

    /**
     * 模块类型筛选
     * @param modularTypeName
     * @param type
     * @return
     */
    private int getModularType(String modularTypeName,int type){
        switch (modularTypeName){
            case StaticInfo.AOP_MODULAR_TYPE_FIRST:
                type = StaticInfo.MODEULARTTYPE_FIRST;
                break;
                //添加多模块
        }
        return type;
    }
    private int getOperationType(JoinPoint joinPoint,Signature signature,int operationType,String methodName){
        switch (methodName){
            case StaticInfo.AOP_OPERATION_TYPE_ADD:
                operationType = StaticInfo.OPERATIONTYPE_ADD;
                break;
            case StaticInfo.AOP_OPERATION_TYPE_EDIT:
                operationType = StaticInfo.OPERATIONTYPE_UPDATE;
                break;
            case StaticInfo.AOP_OPERATION_TYPE_MOVE:
                operationType = StaticInfo.OPERATIONTYPE_MOVER;
                break;
            case StaticInfo.AOP_OPERATION_TYPE_DELETE:
                operationType = StaticInfo.OPERATIONTYPE_DELETE;
                break;
            case StaticInfo.AOP_OPERATION_TYPE_OPENORCLOSE:
                Object[] obj = joinPoint.getArgs();
                int arg = (int)obj[1];
                if (arg == 1){
                    operationType = StaticInfo.OPERATIONTYPE_OPEN;
                } else{
                    operationType = StaticInfo.OPERATIONTYPE_CLOSE;
                }
                break;

        }
        return operationType;
    }
}

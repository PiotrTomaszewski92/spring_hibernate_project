package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    //setup logger
        private Logger myLogger = Logger.getLogger(getClass().getName());
    //setup pointcut declarations
        @Pointcut("execution(* controller.*.*(..))")
        private void forControllerPackage(){}

    //do the same for service and dao
        @Pointcut("execution(* service.*.*(..))")
        private void forServicePackage(){}

        @Pointcut("execution(* dao.*.*(..))")
        private void forDaoPackage(){}

        @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
        private void forAppFlow(){}

    //add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
            String theMethod = joinPoint.getSignature().toShortString();
            myLogger.info("====>>> in @Before calling method: "+theMethod);

            Object[] args = joinPoint.getArgs();
            for (Object arg : args){
                myLogger.info("====>>> Argument: "+arg);
            }
    }

    //add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
           String method = joinPoint.getSignature().toShortString();
            myLogger.info("~~~~>>> in @AfterReturning calling method: "+method);

            myLogger.info("~~~~>>> result: "+result);
    }
}

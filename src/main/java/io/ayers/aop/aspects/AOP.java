package io.ayers.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// Aspect - Pointcut + Advice
//Aop Configuration
@Aspect
@Component
public class AOP {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String serviceLayerPointCut = "io.ayers.aop.aspects.CommonJoinPointConfig.serviceLayerExecution()";
    private final String timeTrackPointCut = "io.ayers.aop.aspects.CommonJoinPointConfig.trackTimeAnnotation()";
    // Pointcut
    //execution(* io.ayers.aop.services.[class].[method]([arguments]))
    @Before(serviceLayerPointCut)
    public void beforeServices(JoinPoint joinPoint) {
        // Advice
        logger.info("BEFORE - Checking User Access: {}", joinPoint);
    }

    @AfterReturning(value = serviceLayerPointCut, returning = "result")
    public void afterServicesReturn(JoinPoint joinPoint, Object result) {
        logger.info("AFTER RETURNING - Returned value: {}", result);
    }

    @AfterThrowing(value= serviceLayerPointCut, throwing="exception")
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        logger.info("AFTER THROWING - ERROR: {}", exception.getMessage());
    }

    @After(serviceLayerPointCut)
    public void afterServices(JoinPoint joinPoint) {
        logger.info("AFTER - Call successful!");
    }

    @Around(timeTrackPointCut)
    public Object aroundServices(ProceedingJoinPoint proceedingJoinPoint) {
        var startTime = System.currentTimeMillis();

        try {
            Object retVal = proceedingJoinPoint.proceed();
            var timeTaken = System.currentTimeMillis() - startTime;

            logger.info("- Execution Time: {}ms", timeTaken);

            return retVal;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return null;
    }
}

package io.ayers.aop.aspects;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonJoinPointConfig {
    @Pointcut("execution(* io.ayers.aop.services.*.*(..))")
    public void serviceLayerExecution() {
    }

    @Pointcut("@annotation(io.ayers.aop.annotations.TrackTime)")
    public void trackTimeAnnotation(){}
}

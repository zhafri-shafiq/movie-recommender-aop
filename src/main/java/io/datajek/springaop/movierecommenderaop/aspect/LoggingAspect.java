package io.datajek.springaop.movierecommenderaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterReturning(
            value = "execution(* io.datajek.springaop.movierecommenderaop.data.*.*(..))",
            returning = "result"
    )
    public void LogAfterExecution(JoinPoint joinPoint, Object result) {
        logger.info("Method {} returned with: {}", joinPoint, result);
    }

    @AfterThrowing(
            value = "execution(* io.datajek.springaop.movierecommenderaop.business.*.*(..))",
            throwing = "exception"
    )
    public void LogAfterException(JoinPoint joinPoint, Object exception) {
        logger.info("Method {} returned with: {}", joinPoint, exception);
    }

    @After("execution(* io.datajek.springaop.movierecommenderaop.business.*.*(..))")
    public void LogAfterMethod(JoinPoint joinPoint) {
        logger.info("After method call {}", joinPoint);
    }
}

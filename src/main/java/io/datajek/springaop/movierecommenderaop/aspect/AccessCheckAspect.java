package io.datajek.springaop.movierecommenderaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AccessCheckAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //@Before("execution(* io.datajek.springaop.movierecommenderaop.business.*.*(String,..))") // Intercepting all method calls in a package
    //@Before("execution(* io.datajek.springaop.movierecommenderaop..*.*(..))") // Intercepting all method calls
    //@Before("execution(String io.datajek.springaop.movierecommenderaop..*.*(..))") // Intercepting calls using return type
    //@Before("execution(String io.datajek.springaop.movierecommenderaop..*.*Filtering(..))") // Intercepting calls to a specific method
    //@Before("execution(* io.datajek.springaop.movierecommenderaop..*.*(String,..))") // Intercepting calls with specific method arguments
    @Before("execution(* io.datajek.springaop.movierecommenderaop..*.*Filtering(..)) || execution(String io.datajek.springaop.movierecommenderaop..*.*(..))")
    //Combining pointcut expressions#
    public void userAccess(JoinPoint joinPoint) {
        //intercept a call
        logger.info("Intercepted call before execution: {}", joinPoint);
        //access check logic
    }
}

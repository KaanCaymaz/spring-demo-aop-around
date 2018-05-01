package com.luv2code.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspect {
	
		private Logger myLogger= Logger.getLogger(getClass().getName());

		@Around("execution(* com.luv2code.aopdemo.service.FortunaService.getFortuna(..))")
		public Object getAroundAspect(ProceedingJoinPoint joinPoint) throws Throwable {
			
			String method = joinPoint.getSignature().toShortString();
			myLogger.info("\n====> Executing @Around on method:"+ method);
			
			long begin= System.currentTimeMillis();
			
			Object result;
			try {
			 result = joinPoint.proceed();
			 
			}catch(Exception exp) {
				myLogger.warning(exp.getMessage());
				result="Highway is closed. But AOP will receive us !!";
			}
			
			long end = System.currentTimeMillis();
			long duration= end-begin;
			myLogger.info("\n ===> Duration: "+duration+" seconds");
			
			return result;
		}
}

package com.bridgelabz.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class EmployeeAspectPointcut {

	@Before("getNamePointcut()")
	public void loggingAdvice() {
		System.out.println("Executing loggingAdvice on getName()");
	}
	@Before("getNamePointcut()")
	public void secondAdvice() {
		System.out.println("Executing second advice on getName()");
	}
	@Pointcut()
	public void getNamePointcut() {
		
	}
	@Before("allMethodsPointcut()")
	public void allServiceMethodsAdvice() {
		System.out.println("Before executing Service method");
	}
	@Pointcut("within(com.bridgelabz.service.*)")
	public void allMethodsPointcut() {
		
	}
	
}

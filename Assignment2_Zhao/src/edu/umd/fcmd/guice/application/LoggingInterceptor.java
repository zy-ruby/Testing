package edu.umd.fcmd.guice.application;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingInterceptor implements MethodInterceptor {
	public Object invoke (MethodInvocation invocation) throws Throwable {
		System.out.println("enter:"+invocation.getMethod().getName());
		try {
			return invocation.proceed();
		} finally {
			System.out.println("exit"+invocation.getMethod().getName());
		}
	}
}

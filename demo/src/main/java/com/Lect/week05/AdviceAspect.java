package com.Lect.week05;

import java.util.Scanner;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdviceAspect {
	
	//Ex1
	@Before("execution(* com.Lect.week05." + "ExAOPService.performSensitiveOperatopn(..)")
	public void authenticate(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		
		System.out.println("[AUTH] 메서드 실행 전 - 메서드 이름: " + methodName);
		System.out.println("[AUTH] 메서드 실행 전 - 인수" + java.util.Arrays.toString(args));
	
		
		boolean isAuthenticated = checkAuthentication();
		if(!isAuthenticated) {
			throw new SecurityException("사용자가 인증되지 않았습니다.");
		}
		System.out.println("[AUTH] 인증 성공 : 사용자가 메서드 실행을 허용받았음.");
		
	}
	
	private boolean checkAuthentication() {
		double value = Math.random();
		return value > 0.5;}
	
	//Ex2
	@Pointcut("execution(* com.Lect..*(..))")
	private void pointcutExp() {}
	
	@AfterReturning(pointcut="pointcutExp()", returning="result")
	public void logAfterReturning(Object result) {
		System.out.println("[LOG] 메서드가 정상적으로 종료되었습니다.");
		System.out.println("[LOG] 반환값: " + result);
	}
	
	@AfterThrowing(pointcut="pointcutExp()", throwing="authException")
	public void exceptionProcess(Throwable authException) {
		System.out.println("======================================");
		System.out.println("예외 발생!!, ㅖ외=" + authException.getMessage());
	}
	@After("pointcutExp()")
	public void logAfter() {
		System.out.println("[INFO] 메서드 실행 후 처리되었습니다.");
	}
	
	
	@Around("execution(* com.Lect.week05.ExAOPService.check(..))")
	public Object checkPermission(ProceedingJoinPoint joinPoint) throws Throwable{
		long startTime = System.currentTimeMillis();
		Object[] args + joinpoint.getArgs();
		
		System.out.println("[Around] 시작 시간 : " + startTime);
		Scanner in = new Scanner(System.in);
		System.out.print("사용자 권한 : ");
		args[0] = in.nextLine();
		
		Object result = joinPoint.proceed(args);
		
		long endTime = System.currentTimeMillis();
		System.out.println("[Around] 메서드 실행 시간 :" + (endTime - startTime) + "ms");
		
		String methodName = joinPoint.getSignature().getName();
		result = "[" + methodName + "]메서드에 대한" + result;
		
		return result;
	}
	

}

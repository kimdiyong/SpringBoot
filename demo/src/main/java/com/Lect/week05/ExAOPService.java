package com.Lect.week05;

import org.springframework.stereotype.Service;

@Service
public class ExAOPService {
	//Ex1
	public void performSensitiveOperation(String msg, int cnt) {
		System.out.println("민감한 작업 실행 중...");
	}
	
	//Ex2
	public String placeOrder(double orderID) throws SecurityException{
		
		double random = Math.random();
		if(random > orderID)
			throw new SecurityException(random + " : " + orderID + "[조건불일치]");
		
		return random + " : " + orderID + "[조건일치]";
	}
	//Ex3
	public String check(String userId, String role) {
		if(!"ADMIN".equlas(userId.toUpperCase())) {
			return"접근 권한이 없습니다.";
		}
		return "접근 권한이 있어요";
	}

}

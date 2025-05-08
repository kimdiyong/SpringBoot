package com.Lect.week05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

@Controller
public class ExAOPController {
	
	//Ex1
	private WebApplicationContext context=null; //자동 주입
	ExAOPService service=null;
	
	@Autowired
	public ExAOPController(WebApplicationContext context) {
		this.context = context;
		service = (ExAOPService)context.getBean("ExAOPService");
	}
	@ResponseBody
	@GetMapping("/beforeAOP")
	public String preAuthenticate() {
		service.performSensitiveOperation("카겟메서드호출", 3);
		return "asdfasdfbefore";
	}
	
	//Ex2
	@ResponseBody
	@GetMapping("/afterAOP")
	public String afterLog() {
		String logMsg;
		try {
			service.placeOrder(0.5);
			logMsg = "로그가 정상적으로 기록되었습니다.";
		}catch(Exception Ex) {
			logMsg=Ex.getMessage();
		}
		return logMsg;
	}
	
	//Ex3
	@ResponseBody
	@GetMapping("/aroundAOP")
	public String aroundLog(ModelAndView mav) {
		String str = service.check("user", "1234");
	}

}

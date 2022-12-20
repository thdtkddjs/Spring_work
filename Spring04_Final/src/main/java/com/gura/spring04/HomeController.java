package com.gura.spring04;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
		
	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		//응답에 필요한 데이터(Model)이라고 가정하다.
		List<String> noticeList=new ArrayList<String>();
		noticeList.add("눈이 내리네요");
		noticeList.add("그대가 들어오죠");
		noticeList.add("다음이 뭐더라");
		//Model을 request scope에 특정 key 값으로 담는다.
		request.setAttribute("noticeList", noticeList);
		// forward이동을 간편하게
		return "home";
	}
	
}

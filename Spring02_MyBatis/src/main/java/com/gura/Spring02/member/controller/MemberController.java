package com.gura.Spring02.member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.Spring02.member.dto.MemberDto;
import com.gura.Spring02.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("/member/update")
	public String update(MemberDto dto) {
		
		service.updateMember(dto);
		
		return "member/update";
	}
	
	@RequestMapping("/member/updateform")
	public ModelAndView updateform(int num, ModelAndView mView) {
		//수정할 회원의 정보를 db에서 불러온다.
		//mView 객체에 담는다.
		service.getMember(num, mView);
		//View page 설정
		mView.setViewName("member/updateform");
		//리턴
		return mView;
	}
	
	@RequestMapping("/member/delete")
	public String delete(int num) {//get 방식 전송 파라미터도 자동으로 추출해준다.
		service.deleteMember(num);
		//다시 리스트로 돌아갈 수 있도록 redirect 이동을 해준다.
		return "redirect:/member/list";
	}
	
	@RequestMapping("/member/insert")
	public String insert(MemberDto dto) {//폼에서 전송되는 정보가 자동으로 dto에 담겨 전송
		service.addMember(dto);
		
		// /WEB-INF/views/member/insert.jsp로 forward이동해서 응답
		return "member/insert";
	}
	
	@RequestMapping("/member/insertform")
	public String insertform() {
		// /WEB-INF/views/member/insertform.jsp로 forward이동해서 응답
		return "member/insertform";
	}
	
	@RequestMapping("/member/list")
	public ModelAndView getList(ModelAndView mView) {
		//DI된 객체를 이용해서 회원 정보를 읽어온다.
		service.getListMember(mView);
		//mView에 전달할 model과 view page 정보를 담는다.
		mView.setViewName("member/list");
		
		//리턴해준다.
		return mView;
	}
}

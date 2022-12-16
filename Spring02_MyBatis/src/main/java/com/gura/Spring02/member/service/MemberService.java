package com.gura.Spring02.member.service;

import org.springframework.web.servlet.ModelAndView;

import com.gura.Spring02.member.dto.MemberDto;

public interface MemberService {
	//필요한 각종 메소드를 만들어둔다.
	public void addMember(MemberDto dto);
	
	public void updateMember(MemberDto dto);
	
	public void deleteMember(int num);
	
	public void getMember(int num, ModelAndView mView);
	
	public void getListMember(ModelAndView mView);
}

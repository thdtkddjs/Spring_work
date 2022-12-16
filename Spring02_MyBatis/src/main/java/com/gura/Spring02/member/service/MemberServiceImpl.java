package com.gura.Spring02.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.Spring02.member.dao.MemberDao;
import com.gura.Spring02.member.dto.MemberDto;

//component scan을 통해서 스프링이 관리하는 bean이 되게 하기 위한 어노테이션
@Service
public class MemberServiceImpl implements MemberService{

	//핵심 의존 객체 DI(주입)
	@Autowired
	private MemberDao dao;
	
	@Override
	public void addMember(MemberDto dto) {
		dao.insert(dto);
	}

	@Override
	public void updateMember(MemberDto dto) {
		dao.update(dto);
	}

	@Override
	public void deleteMember(int num) {
		dao.delete(num);
	}

	@Override
	public void getMember(int num, ModelAndView mView) {
		
		MemberDto dto= dao.getData(num);
		
		mView.addObject("dto", dto);
		
	}

	@Override
	public void getListMember(ModelAndView mView) {
		
		List<MemberDto> list=dao.getList();
		
		mView.addObject("list", list);
	}

}

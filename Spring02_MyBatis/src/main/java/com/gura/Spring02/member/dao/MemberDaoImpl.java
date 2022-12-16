package com.gura.Spring02.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.Spring02.member.dto.MemberDto;

//component scan을 통해서 spring이 관리하는 bean이 될 수 있도록 어노테이션 붙여놓기
@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private SqlSession session;//각종 작업을 하기 위한 핵심 의존 객체

	@Override
	public void insert(MemberDto dto) {
		/*
		 * mapper's namespace => member
		 * sql's id => insert
		 * parameterType => MemberDto
		 */
		session.insert("member.insert", dto);
	}

	@Override
	public void update(MemberDto dto) {
		session.update("member.update", dto);
		
	}

	@Override
	public void delete(int num) {
		
		session.delete("member.delete", num);
	}

	@Override
	public MemberDto getData(int num) {
		MemberDto dto=session.selectOne("member.getData",num);
		
		return dto;
	}

	@Override
	public List<MemberDto> getList() {
/*
 * 구문으로부터 아래와 같은 정보를 얻어낼 수 있어야한다.
 * mapper's namespace=>member
 * sql's id=> getList
 * resultType=>memberDto
 * return type=>List
 * 
 */
		List<MemberDto> list=session.selectList("member.getList");
		return list;
	}

}

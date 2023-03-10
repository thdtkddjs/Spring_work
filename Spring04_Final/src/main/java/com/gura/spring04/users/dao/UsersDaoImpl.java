package com.gura.spring04.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring04.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao{

	@Autowired
	private SqlSession session;
	
	@Override
	public boolean isExist(String inputId) {
		UsersDto dto = session.selectOne("users.getData", inputId);
		if(dto==null) {
			return false;
		}else {
			return true;
		}
		
	}

	@Override
	public void insert(UsersDto dto) {
		
		session.insert("users.insert", dto);
	}

	@Override
	public UsersDto getData(String id) {
		UsersDto dto = session.selectOne("users.getData", id);
		
		return dto;
	}

	@Override
	public void updatePwd(UsersDto dto) {

		session.update("users.updatePwd", dto);
		
	}

	@Override
	public void update(UsersDto dto) {

		session.update("users.update", dto);
		
	}

	@Override
	public void delete(String id) {
		session.delete("users.delete", id);
	}

}

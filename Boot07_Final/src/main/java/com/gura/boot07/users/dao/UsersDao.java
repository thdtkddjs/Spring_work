package com.gura.boot07.users.dao;

import com.gura.boot07.users.dto.UsersDto;

public interface UsersDao {
	//아이디의 존재 여부를 판정
		public boolean isExist(String inputId);
		//가입하는 회원의 정보를 DB에 저장
		public void insert(UsersDto dto);
		//아이디에 해당하는 정보를 리턴
		public UsersDto getData(String id);
		//비밀번호를 수정
		public void updatePwd(UsersDto dto);
		//개인정보를 수정
		public void update(UsersDto dto);
		//회원의 정보를 삭제
		public void delete(String id);
}

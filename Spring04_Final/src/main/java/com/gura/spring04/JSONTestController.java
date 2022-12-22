package com.gura.spring04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spring04.users.dto.UsersDto;

/*
 * 1. jackson-databind 라이브러리가 dependency에 명시가 되있고
 * 2. servlet-context.xml에 <annotation-driven/>이 명시가 되있고
 * 3. 컨트롤러의 메소드에 @ResponseBody 어노테이션이 붙어있으면
 * Map or dto or List 객체에 담긴 내용이 json 문자열로 변환되어 응답한다.
 */
@Controller
public class JSONTestController {
	
	@ResponseBody
	@RequestMapping("/get_msg")
	public String getMsg() {
		return "hello";
	}
	
	@ResponseBody
	@RequestMapping("/get_person")
	public Map<String, Object> getPerson(){
		Map<String,Object> map=new HashMap<>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("isMan", true);
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/get_user")
	public UsersDto getUser(){
		UsersDto dto=new UsersDto();
		dto.setId("gura");
		dto.setPwd("1234");
		dto.setEmail("@");
		
		return dto;
	}
	
	@ResponseBody
	@RequestMapping("/get_friends")
	public List<String> getFriends(){
		List<String> friends=new ArrayList<>();
	
		friends.add("김구라");
		friends.add("해골");
		friends.add("원숭이");
		
		return friends;
	}
	
	@ResponseBody
	@RequestMapping("/get_users")
	public List<UsersDto> getUsers(){
		List<UsersDto> list=new ArrayList<>();
		
		UsersDto dto1=new UsersDto();
		dto1.setId("gura");
		dto1.setPwd("1234");
		dto1.setEmail("@");
		
		UsersDto dto2=new UsersDto();
		dto2.setId("monkey");
		dto2.setPwd("1234");
		dto2.setEmail("@2");
		
		list.add(dto1);
		list.add(dto2);
		
		return list;
	}
	
}
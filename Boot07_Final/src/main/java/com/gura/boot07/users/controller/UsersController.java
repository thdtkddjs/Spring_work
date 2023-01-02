package com.gura.boot07.users.controller;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.boot07.users.dto.UsersDto;
import com.gura.boot07.users.service.UsersService;

@Controller
public class UsersController {
	
	@Autowired
	private UsersService service;
	
	/*
	 * get방식 요청을 처리할 메소드
	 * - 요청 방식이 다를 경우 실행되지 않는다.
	 */
	@RequestMapping(method = RequestMethod.GET, value= "/users/signup_form" )
	public String signupForm() {
		
		return "users/signup_form";
	}
	
	@RequestMapping("/users/signup")
	public ModelAndView signup(ModelAndView mView, UsersDto dto) {
		
		service.addUser(dto);
		mView.setViewName("users/signup");
		return mView;
	}
	
	@RequestMapping("/users/loginform")
	public String loginform() {
		return "users/loginform";
	}
	
	@RequestMapping("/users/login")
	public ModelAndView login(ModelAndView mView, UsersDto dto, String url, HttpSession session) {
		service.loginProcess(dto, session);
		
		//로그인 후에 가야할 목적지 정보를 인코딩 전, 후 모두 담는다.
		String encodeUrl=URLEncoder.encode(url);
		mView.addObject("url", url);
		mView.addObject("encodeUrl", encodeUrl);
		
		//view page로 forward 이동해서 응답한다.
		mView.setViewName("users/login");
		return mView;
	}
	
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		return "users/logout";
	}
	
	@RequestMapping("/users/info")
	public ModelAndView info(HttpSession session, ModelAndView mView) {
		
		service.getInfo(session, mView);
		
		mView.setViewName("users/info");
		return mView;
	}
	
	@RequestMapping("/users/pwd_updateform")
	public String pwdUpdateForm() {
		
		return "users/pwd_updateform";
	}
	
	@RequestMapping("/users/pwd_update")
	public ModelAndView pwdUpdate(UsersDto dto, ModelAndView mView, HttpSession session) {
		//서비스에 필요한 객체의 참조값을 전달해준다.
		service.updateUserPwd(session, dto, mView);
		
		mView.setViewName("users/pwd_update");
		return mView;
	}
	
	@RequestMapping("/users/delete")
	public ModelAndView delete(HttpSession session,ModelAndView mView) {
		service.deleteUser(session, mView);
		
		mView.setViewName("users/delete");
		return mView;
	}
	
	@RequestMapping("/users/updateform")
	public ModelAndView updateform(HttpSession session, ModelAndView mView) {
		service.getInfo(session, mView);
		mView.setViewName("users/updateform");
		return mView;
	}
	//개인정보 수정 반영 요청 처리
	@RequestMapping(value="/users/update", method=RequestMethod.POST)
	public ModelAndView Update(UsersDto dto, HttpSession session, ModelAndView mView) {
		service.updateUser(dto, session);
		mView.setViewName("redirect:/users/info");
		return mView;
	}
	
	@RequestMapping(value= "/users/profile_upload", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> profileUpload(HttpServletRequest request,MultipartFile image){
		//서비스를 이용해서 이미지를 upload폴더에 저장하고, 리턴되는 MAP을 이용해서 json문자열 응답하기
		return service.saveProfileImage(request, image);
	}
}

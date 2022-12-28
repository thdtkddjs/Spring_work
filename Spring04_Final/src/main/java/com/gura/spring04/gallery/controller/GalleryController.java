package com.gura.spring04.gallery.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.gallery.dto.GalleryDto;
import com.gura.spring04.gallery.service.GalleryService;

@Controller
public class GalleryController {
	
	@Autowired
	private GalleryService service;
	
	@RequestMapping("/gallery/list")
	public ModelAndView list(ModelAndView mView) {
		service.getList(mView);
		mView.setViewName("gallery/list");
		return mView;
	}
	
	@RequestMapping("/gallery/insertform")
	public String insertForm() {
		
		return "gallery/insertform";
	}
	
	@RequestMapping("/gallery/insert")
	public ModelAndView insert(GalleryDto dto, ModelAndView mView, 
			HttpServletRequest request) {
		System.out.println(dto.getNum()+dto.getWriter()+dto.getImagePath()+dto.getCaption()+dto.getRegdate());
		
		service.addImage(dto, mView, request);
		mView.setViewName("gallery/insert");
		return mView;
	}
	
	@RequestMapping(value= "/gallery/profile_upload", method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> profileUpload(HttpServletRequest request,MultipartFile image){
		//서비스를 이용해서 이미지를 upload폴더에 저장하고, 리턴되는 MAP을 이용해서 json문자열 응답하기
		return service.saveProfileImage(request, image);
	}
	
	@RequestMapping("/gallery/detail")
	public ModelAndView detailImage(ModelAndView mView, HttpServletRequest request) {
		service.detailImage(request, mView);
		mView.setViewName("gallery/detail");
		return mView;
	}
}

package com.gura.spring04.cafe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.cafe.dto.CafeDto;
import com.gura.spring04.cafe.service.CafeService;

@Controller
public class CafeController {
	
	@Autowired
	private CafeService service;
	
	@RequestMapping("/cafe/list")
	public String list(HttpServletRequest request) {
		service.getList(request);
		
		return "cafe/list";
	}
	
	@RequestMapping("/cafe/insertform")
	public String insertform() {
		
		return "cafe/insertform";
	}
	
	@RequestMapping("/cafe/insert")
	public String insert(CafeDto dto) {
		service.saveContent(dto);
		
		return "cafe/insert";
	}
	
	@RequestMapping("/cafe/detail")
	public String detail(HttpServletRequest request) {
		service.getDetail(request);
		
		return "cafe/detail";
	}
	
	@RequestMapping("/cafe/delete")
	public String detail(int num, HttpServletRequest request) {
		service.deleteContent(num, request);
		return "cafe/delete";
	}
	
	@RequestMapping("/cafe/updateform")
	public String updateform(HttpServletRequest request) {
		service.getData(request);
		return "cafe/updateform";
	}
	
	@RequestMapping("/cafe/update")
	public String update(CafeDto dto) {
		service.updateContent(dto);
		return "cafe/update";
	}
}

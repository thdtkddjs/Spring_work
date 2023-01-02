package com.gura.boot07.cafe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gura.boot07.cafe.dto.CafeCommentDto;
import com.gura.boot07.cafe.dto.CafeDto;
import com.gura.boot07.cafe.service.CafeService;

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
	   //새로운 댓글 저장 요청 처리
	   @RequestMapping("/cafe/comment_insert")
	   public String commentInsert(HttpServletRequest request, int ref_group) {
	      
	      service.saveComment(request);
	   
	      return "redirect:/cafe/detail?num="+ref_group;
	   }
	   //댓글 더보기 요청 처리
	   @RequestMapping("/cafe/ajax_comment_list")
	   public String commentList(HttpServletRequest request) {
	      
	      service.moreCommentList(request);
	      
	      return "cafe/ajax_comment_list";
	   }
	   //댓글 삭제 요청 처리
	   @RequestMapping("/cafe/comment_delete")
	   @ResponseBody
	   public Map<String, Object> commentDelete(HttpServletRequest request) {
	      service.deleteComment(request);
	      Map<String, Object> map=new HashMap<String, Object>();
	      map.put("isSuccess", true);
	      // {"isSuccess":true} 형식의 JSON 문자열이 응답되도록 한다. 
	      return map;
	   }
	   //댓글 수정 요청처리 (JSON 을 응답하도록 한다)
	   @RequestMapping("/cafe/comment_update")
	   @ResponseBody
	   public Map<String, Object> commentUpdate(CafeCommentDto dto, HttpServletRequest request){
	      service.updateComment(dto);
	      Map<String, Object> map=new HashMap<String, Object>();
	      map.put("isSuccess", true);
	      // {"isSuccess":true} 형식의 JSON 문자열이 응답되도록 한다. 
	      return map;
	   }
}
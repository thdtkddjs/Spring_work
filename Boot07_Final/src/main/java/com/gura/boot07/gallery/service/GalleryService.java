package com.gura.boot07.gallery.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.boot07.gallery.dto.GalleryDto;
import com.gura.boot07.file.dto.FileDto;

public interface GalleryService {
	
	public void getList(ModelAndView mView);
	
	public void addImage(GalleryDto dto, ModelAndView mView,
	         HttpServletRequest request);
	
	public void updateImage(GalleryDto dto, ModelAndView mView, 
			HttpServletRequest request);
	
	public void deleteImage(HttpServletRequest request, ModelAndView mView);
	
	public void detailImage(HttpServletRequest request, ModelAndView mView);
	
	public Map<String, Object> saveProfileImage(HttpServletRequest request, MultipartFile mFile);
}

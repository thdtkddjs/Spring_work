package com.gura.boot07.gallery.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.gura.boot07.gallery.dao.GalleryDao;
import com.gura.boot07.gallery.dto.GalleryDto;

@Service
public class GalleryServiceImpl implements GalleryService{
	
	@Autowired
	private GalleryDao dao;
	
	@Override
	public void getList(ModelAndView mView) {
		List<GalleryDto> list=dao.getList();
		mView.addObject("list", list);
		
	}

	@Override
	public void addImage(GalleryDto dto, ModelAndView mView, HttpServletRequest request) {
		dao.insert(dto);
		mView.addObject("dto", dto);
	}

	@Override
	public void updateImage(GalleryDto dto, ModelAndView mView, HttpServletRequest request) {
		dao.update(dto);
		mView.addObject("dto", dto);
	}

	@Override
	public void deleteImage(HttpServletRequest request, ModelAndView mView) {
		int num=Integer.parseInt(request.getParameter("num"));
		dao.delete(num);
	}

	@Override
	public Map<String, Object> saveProfileImage(HttpServletRequest request, MultipartFile mFile) {
	      //업로드된 파일에 대한 정보를 MultipartFile 객체를 이용해서 얻어낼수 있다.   
	      
	      //원본 파일명
	      String orgFileName=mFile.getOriginalFilename();
	      //upload 폴더에 저장할 파일명을 직접구성한다.
	      // 1234123424343xxx.jpg
	      String saveFileName=System.currentTimeMillis()+orgFileName;
	      
	      // webapp/upload 폴더까지의 실제 경로 얻어내기 
	      String realPath=request.getServletContext().getRealPath("/upload");
	      // upload 폴더가 존재하지 않을경우 만들기 위한 File 객체 생성
	      File upload=new File(realPath);
	      if(!upload.exists()) {//만일 존재 하지 않으면
	         upload.mkdir(); //만들어준다.
	      }
	      try {
	         //파일을 저장할 전체 경로를 구성한다.  
	         String savePath=realPath+File.separator+saveFileName;
	         //임시폴더에 업로드된 파일을 원하는 파일을 저장할 경로에 전송한다.
	         mFile.transferTo(new File(savePath));
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	      
	      // json 문자열을 출력하기 위한 Map 객체 생성하고 정보 담기 
	      Map<String, Object> map=new HashMap<String, Object>();
	      map.put("imagePath", "/upload/"+saveFileName);
	      
	      return map;
	}

	@Override
	public void detailImage(HttpServletRequest request, ModelAndView mView) {
		int num = Integer.parseInt(request.getParameter("num"));
		GalleryDto dto=dao.getData(num);
		mView.addObject("dto", dto);
		request.setAttribute("dto", dto);
	}
}

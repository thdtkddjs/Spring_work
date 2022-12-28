package com.gura.spring04.gallery.dao;

import java.util.List;

import com.gura.spring04.gallery.dto.GalleryDto;

public interface GalleryDao {
	
	public List<GalleryDto> getList();
	
	public void insert(GalleryDto dto);
	
	public void delete(int num);
	
	public void update(GalleryDto dto);
	
	public GalleryDto getData(int num);
}

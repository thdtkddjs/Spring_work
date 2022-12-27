package com.gura.spring04.shop.dao;

import java.util.List;

import com.gura.spring04.shop.dto.ShopDto;

public interface ShopDao {
	//상품 목록을 리턴
	public List<ShopDto> getList();
	//상품 재고 감소
	public void minusCount(int num);
	//잔고 감소
	public void minusMoney(ShopDto dto);
	//포인트를 증가
	public void plusPoint(ShopDto dto);
	//상품 가격을 리턴
	public int getPrice(int num);
}

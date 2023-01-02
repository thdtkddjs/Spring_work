package com.gura.boot07.shop.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.gura.boot07.shop.dao.OrderDao;
import com.gura.boot07.shop.dao.ShopDao;
import com.gura.boot07.shop.dto.OrderDto;
import com.gura.boot07.shop.dto.ShopDto;
import com.gura.boot07.exception.DeliveryException;

@Service
public class ShopServiceImpl implements ShopService{

	@Autowired
	private ShopDao shopDao;
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public void getList(ModelAndView mView) {
		
		List<ShopDto> list=shopDao.getList();
		
		mView.addObject("list", list);
	}

	/*
	 * -Spring 트랜젝션 설정 방법
	 * 1. pom.xml에 spring-tx dependency 추가
	 * 2. servlet-context.xml에 transaction 설정 추가
	 * 3. 트랜젝션을 관리할 서비스의 메소드에 @Transactional 어노테이션 붙이기
	 * 
	 * -프로그래머의 의도 하에서 트랜젝션에 영향을 주는 Exception을 발생시키는 방법
	 * DataAccessException 클래스를 상속받은 클래스를 정의하고
	 * 예) Class MyException extends DataAccessException{}
	 * 		throw new MyException("에외 메시지");
	 * 
	 * 예외를 발생시킬 조건이라면 위와 같이 예외를 발생시켜서 트랜젝션이 관리되도록 한다.
	 */
	@Transactional
	@Override
	public void buy(HttpServletRequest request, ModelAndView mView) {
		//구입자의 아이디를 인식
		String id=(String) request.getSession().getAttribute("id");
		//상품의 번호 담아두기
		int num=Integer.parseInt(request.getParameter("num"));
		//상품의 가격 담아두기	
		int price=shopDao.getPrice(num);
		//dto에 상품의 정보 담아서 활용하기
		ShopDto dto=new ShopDto();
		dto.setId(id);
		dto.setPrice(price);
		shopDao.minusMoney(dto);
		shopDao.plusPoint(dto);
		shopDao.minusCount(num);
		//주문 정보를 저장하기
		OrderDto dto2=new OrderDto();
		//상품 번호를 저장
		dto2.setCode(num);//어떤 정보를
		//주소를 저장
		String addr="제주도 삼원타워";
		dto2.setid(id);//누가
		dto2.setAddr(addr);//어디로(클라이언트가 배송주소를 입력해서 넘겨준것으로 가정)
		
		if(addr.contains("제주도")) {
			throw new DeliveryException("제주도는 배송 불가지역입니다");
		}
		orderDao.addOrder(dto2);
	}

}

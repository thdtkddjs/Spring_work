package com.gura.boot07.exception;

import org.springframework.dao.DataAccessException;

/*
 * 트랜젝션에 영향을 주는 예외 클래스를 만들기
 * -DataAccessException 클래스를 상속받아서 만든다.
 */
public class DeliveryException extends DataAccessException{

	public DeliveryException(String msg) {
		super(msg);
		
	}

}

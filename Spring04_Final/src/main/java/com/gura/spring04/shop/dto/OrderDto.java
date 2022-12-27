package com.gura.spring04.shop.dto;

public class OrderDto {
	private int num;
	private String name;
	private int code;
	private String addr;	
	
	public OrderDto() {}

	public OrderDto(int num, String name, int code, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.code = code;
		this.addr = addr;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}

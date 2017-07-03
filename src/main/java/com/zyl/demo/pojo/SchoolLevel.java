package com.zyl.demo.pojo;

public enum SchoolLevel {
	A("1A",1),B("1B",2),C("1C",3);
	
	private String desc;
	private int index;
	
	private SchoolLevel(String desc,int index) {
		this.desc = desc;
		this.index = index;
	}
}

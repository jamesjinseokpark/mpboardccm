package com.hk.pilot.dto;

import java.util.Date;

public class Chat {
	String w_id;
	int c_no;
	Date c_date;
	String c_content;
	String c_title;
	public String getW_id() {
		return w_id;
	}
	public void setW_id(String w_id) {
		this.w_id = w_id;
	}
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public Date getC_date() {
		return c_date;
	}
	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public String getC_title() {
		return c_title;
	}
	public void setC_title(String c_title) {
		this.c_title = c_title;
	}
	
	@Override
	public String toString() {
		return "Chat [w_id=" + w_id + ", c_no=" + c_no +  ", c_date=" + c_date + ", c_content="
				+ c_content + ", c_title=" + c_title  + "]";
	}
	
		
}

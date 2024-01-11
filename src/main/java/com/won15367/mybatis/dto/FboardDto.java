package com.won15367.mybatis.dto;

import java.sql.Timestamp;

public class FboardDto {
	
	private int fbnum; // 게시판 글번호
	private String fbtitle; // 게시판 제목
	private String fbname; // 게시판 글쓴이
	private String fbcontent; // 게시판 내용
	private int fbhit; // 글 조회수
	private Timestamp fbdate; // 글 등록일시
	
	public FboardDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FboardDto(int fbnum, String fbtitle, String fbname, String fbcontent, int fbhit, Timestamp fbdate) {
		super();
		this.fbnum = fbnum;
		this.fbtitle = fbtitle;
		this.fbname = fbname;
		this.fbcontent = fbcontent;
		this.fbhit = fbhit;
		this.fbdate = fbdate;
	}
	public int getFbnum() {
		return fbnum;
	}
	public void setFbnum(int fbnum) {
		this.fbnum = fbnum;
	}
	public String getFbtitle() {
		return fbtitle;
	}
	public void setFbtitle(String fbtitle) {
		this.fbtitle = fbtitle;
	}
	public String getFbname() {
		return fbname;
	}
	public void setFbname(String fbname) {
		this.fbname = fbname;
	}
	public String getFbcontent() {
		return fbcontent;
	}
	public void setFbcontent(String fbcontent) {
		this.fbcontent = fbcontent;
	}
	public int getFbhit() {
		return fbhit;
	}
	public void setFbhit(int fbhit) {
		this.fbhit = fbhit;
	}
	public Timestamp getFbdate() {
		return fbdate;
	}
	public void setFbdate(Timestamp fbdate) {
		this.fbdate = fbdate;
	}
	
	
	
	

}

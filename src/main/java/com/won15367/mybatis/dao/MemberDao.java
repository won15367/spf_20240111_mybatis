package com.won15367.mybatis.dao;

import com.won15367.mybatis.dto.MemberDto;

public interface MemberDao {

	public void joinDao(String mid, String mpw, String mname, String memail);
	
	public MemberDto checkIdDao(String checkId);
	
	public int loginDao (String mid, String mpw);
	
	public MemberDto write_form(String mid);
}

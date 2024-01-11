package com.won15367.mybatis.dao;

import java.util.ArrayList;

import com.won15367.mybatis.dto.FboardDto;

public interface MybatisDao {
	
	public ArrayList<FboardDto> listDao(); // 게시판의 모든 글 목록 가져오기
	
	public void writeDao(String fbname, String fbtitle, String fbcontent);

}

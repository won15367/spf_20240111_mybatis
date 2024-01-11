package com.won15367.mybatis.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.won15367.mybatis.dao.MybatisDao;
import com.won15367.mybatis.dto.FboardDto;

@Controller
public class MybatisController {
	
	@Autowired  // 의존 자동 주입
	private SqlSession sqlSession;
	
	@RequestMapping(value="/list")
	public String list(Model model) {
		
		MybatisDao dao = sqlSession.getMapper(MybatisDao.class);  // dao객체 주입
		
		ArrayList<FboardDto> dtos = dao.listDao();
		
		model.addAttribute("fboardDtos", dtos);
		
		return "list";
	}
	
	@RequestMapping(value="/write_form")
	public String write_form() {
		return "write_form";
	}
	
	@RequestMapping(value="/write")
	public String write(HttpServletRequest request) {
		
		String fbname = request.getParameter("fbname");
		String fbtitle = request.getParameter("fbtitle");
		String fbcontent = request.getParameter("fbcontent");
		
		MybatisDao dao = sqlSession.getMapper(MybatisDao.class);
		
		dao.writeDao(fbname, fbtitle, fbcontent);
		
		return "redirect:list";
	}

}

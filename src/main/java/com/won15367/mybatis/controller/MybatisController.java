package com.won15367.mybatis.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.won15367.mybatis.dao.MemberDao;
import com.won15367.mybatis.dao.MybatisDao;
import com.won15367.mybatis.dto.FboardDto;
import com.won15367.mybatis.dto.MemberDto;

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
	public String write_form(HttpSession session, Model model) {
		
		String sid = (String) session.getAttribute("sessionId");
		
		if (sid == null) {
			return "redirect:login";
		} else {
			
			MemberDao dao = sqlSession.getMapper(MemberDao.class);
			MemberDto dto = dao.write_form(sid);
			
			model.addAttribute("dto", dto);
			
			return "write_form";
		}
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
	
	@RequestMapping(value="content_view")
	public String content_view(HttpServletRequest request, Model model) {
		
		String fbnum = request.getParameter("fbnum");
		
		MybatisDao dao = sqlSession.getMapper(MybatisDao.class);
		FboardDto dto = dao.content_viewDao(fbnum);
		
		model.addAttribute("fboardDto", dto);
		
		return "content_view";
	}
	
	@RequestMapping(value="modify_form")
	public String modify_form(HttpServletRequest request, Model model) {
		
		String fbnum = request.getParameter("fbnum");
		
		MybatisDao dao = sqlSession.getMapper(MybatisDao.class);
		FboardDto dto = dao.content_viewDao(fbnum);
		
		model.addAttribute("fboardDto", dto);
		
		return "modify_form";
	}
	
	@RequestMapping(value="modify")
	public String modify(HttpServletRequest request, Model model) {
		
		String fbnum = request.getParameter("fbnum");
		String fbname = request.getParameter("fbname");
		String fbtitle = request.getParameter("fbtitle");
		String fbcontent = request.getParameter("fbcontent");
		
		MybatisDao dao = sqlSession.getMapper(MybatisDao.class);
		
		dao.modifyDao(fbname, fbtitle, fbcontent, fbnum);
		
		return "redirect:list";
	}
	
	@RequestMapping(value="delete")
	public String delete(HttpServletRequest request) {
		
		String fbnum = request.getParameter("fbnum");
		
		MybatisDao dao = sqlSession.getMapper(MybatisDao.class);
		dao.deleteDao(fbnum);
		
		return "redirect:list";
	}
	
	@RequestMapping(value="search")
	public String search(HttpServletRequest request, Model model) {
		
		String searchKey = request.getParameter("searchKey");
		
		MybatisDao dao = sqlSession.getMapper(MybatisDao.class);
		ArrayList<FboardDto> dtos = dao.searchDao(searchKey);
		
		model.addAttribute("fboardDtos", dtos);
		
		return "list";
	}

	
}

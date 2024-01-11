package com.won15367.mybatis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.won15367.mybatis.dao.MemberDao;
import com.won15367.mybatis.dto.MemberDto;

@Controller
public class MemberController {
	
	@Autowired  // 의존 자동 주입
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		dao.joinDao(request.getParameter("mid"), request.getParameter("mpw"), request.getParameter("mname"), request.getParameter("memail"));
		
		model.addAttribute("mname", request.getParameter("mname"));
		
		return "joinOk";
	}
	
	@RequestMapping(value = "/checkId")
	public String checkId(HttpServletRequest request, Model model) {
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		MemberDto mDto = dao.checkIdDao(request.getParameter("checkId"));
		
		if (mDto == null) {
			model.addAttribute("idFlag", "1");
		} else {
			model.addAttribute("idFlag", "0");
		}
		
		return "checkId";
	}
	
	@RequestMapping(value = "login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "loginOk")
	public String loginOk(HttpServletRequest request, Model model, HttpSession session) {
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		int loginFlag = dao.loginDao(request.getParameter("mid"), request.getParameter("mpw"));
		
		System.out.print(loginFlag);
		
		if (loginFlag == 1) {
			session.setAttribute("sessionId", request.getParameter("mid"));
		}
		
		return "loginOk";
	}
	
	@RequestMapping(value = "logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "login";
	}
	

}

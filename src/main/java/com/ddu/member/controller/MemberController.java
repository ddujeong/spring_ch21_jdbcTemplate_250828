package com.ddu.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ddu.member.dao.MemberDao;
import com.ddu.member.dto.MemberDto;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}
	@RequestMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		
		String mid = request.getParameter("memberid");
		String mpw = request.getParameter("memberpw");
		String mname = request.getParameter("membername");
		int mage = Integer.parseInt(request.getParameter("memberage"));
		
		// MemberDao memberDao = new MemberDao();
		// memberDao.insertMember(mid, mpw, mname, mage);
		
		memberDao.insertMember(mid, mpw, mname, mage);
		
		return "redirect:memberList";
	}
	@RequestMapping(value = "/memberList")
	public String memberList(Model model) {
		
		List<MemberDto> memberDtos =memberDao.searchMembers();
		model.addAttribute("mDtos",memberDtos);
		return "memberList";
	}
	@RequestMapping(value = "/search")
	public String search() {
		return "searchMember";
	}
	@RequestMapping(value = "/searchOk")
	public String searchOk(HttpServletRequest request, Model model) {
		MemberDto memberDto = memberDao.searchMember(request.getParameter("memberid"));
		model.addAttribute("memberDto",memberDto);
		model.addAttribute("result","1");
		return "searchMember";
	}
}

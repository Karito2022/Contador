package com.karitoreyes.project.controllers;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContadorController {
	@RequestMapping("/")
	public String index(HttpSession session){
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer currentCount = (Integer) session.getAttribute("count");
			session.setAttribute("count", currentCount+1);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/contador")
	public String showCount(HttpSession session, Model model, HttpServletRequest request) {
		String serverName = request.getRequestURL().toString().replace("/contador","");;
		model.addAttribute("serverName", serverName);
		if (session.getAttribute("count") == null) {
			model.addAttribute("countToShow", 0);
		}
		else {
			Integer currentCount = (Integer) session.getAttribute("count");
			model.addAttribute("countToShow", currentCount);
		}
		return "showCount.jsp";
	}
	
	@RequestMapping("/contador2")
	public String increaseby2(HttpSession session){
		if (session.getAttribute("count") != null) {
			Integer currentCount = (Integer) session.getAttribute("count");
			session.setAttribute("count", currentCount+1);
		}
		return "redirect:/contador";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session){
		if (session.getAttribute("count") != null) {
			session.setAttribute("count", 0);
		}
		return "redirect:/contador";
	}
}
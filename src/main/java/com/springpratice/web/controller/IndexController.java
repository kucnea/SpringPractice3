package com.springpratice.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("index controller");
		ModelAndView mv = new ModelAndView();
		mv.addObject("data","Hello Spring MVC!");
		mv.setViewName("/WEB-INF/view/index.jsp"); //절대경로
		// "WEB-INF/view/index.jsp" 이렇게 하면 상대경로임. dispatcher-servlet에서 url을 /aa/index로 한다면 aa/WEB-INF/.. 이렇게 되어야함
		
		return mv;
	}
	
}
 
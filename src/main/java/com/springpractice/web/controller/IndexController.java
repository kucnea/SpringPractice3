package com.springpractice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController /*implements Controller*/{
	
	@RequestMapping("/index")
	public void aaaa() {
		System.out.println("test");
	}

// annotation 으로 url mapping할 경우 하기 내용 불필요
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
//		System.out.println("index controller");
//		
//		/* version1
//		ModelAndView mv = new ModelAndView();
//		//아래에 setViewName을 사용하지않고, new ModelAndView("/WEB-INF/view/index.jsp"); 
//		//도 가능.
//		mv.addObject("data","Hello Spring MVC!");
//		mv.setViewName("/WEB-INF/view/index.jsp"); //절대경로
//		// "WEB-INF/view/index.jsp" 이렇게 하면 상대경로임. dispatcher-servlet에서 url을 /aa/index로 한다면 aa/WEB-INF/.. 이렇게 되어야함
//		*/
//		
//		// version2
//		ModelAndView mv = new ModelAndView("root.index"); //tiles 이용을 위해 강제로 root.으로 분류
//		mv.addObject("data","Hello Spring MVC!");
//		
//		return mv;
//	}

}
 
package com.springpractice.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController /*implements Controller*/{
	
	//이전 방식으로는 이 class가 url에 mapping 되는 방식이였는데
	//이제는 method가 mapping되므로 
	//메소드가 더 생성되면 더 많은 url을 만들 수 있음.
	//각각의 method들이 하나의 controller가 된 것.
	//이 class는 이제 controlle들이 담긴 폴더처럼 된 것.
	@RequestMapping("/index")
	public String index() {	//url과 method명을 맞추는 것이 관리에 용이
		
		
		
		return "root.index";
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
 
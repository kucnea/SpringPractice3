package com.springpractice.web.controller.customer;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springpractice.web.entity.Notice;
import com.springpractice.web.service.NoticeService;

@Controller
@RequestMapping("/customer/notice/")
public class NoticeController{

	//1번 위치. 여기에 Autowired를 할 경우 하기 Autowired외에 무언가 처리될 수는 없음.
	//대신 1번 위치에 Autowired를 할 경우 하기 생성자는 필요 없음.
	@Autowired
	private NoticeService noticeService;
	
	/*
	 * <!-- <property name="noticeService" ref="noticeService"/>  -->
	 * servlet-context에서 프로퍼티 설정을 해제하고 여기서 어노테이션으로 처리.
	 */
//	@Autowired //2번 위치. 여기에 Autowired를 할 경우 이 생성자 실행시에 어떤 코드가 실행될때 같이 할 수 있음.
//	public void setNoticeService(NoticeService noticeService) {
//		this.noticeService = noticeService;
//	}

	@RequestMapping("list")			//value로도 동일하게 가능, 중복 X // 기본값의 필요 여부, default값은 ture
	public String list(@RequestParam(name = "p", required = false) Integer page, Model model) throws ClassNotFoundException, SQLException {
//		String p = request.getParameter("p");
		System.out.println("page"+page);
		
		List<Notice> list = noticeService.getList(1, "TITLE", "");
		model.addAttribute("list",list);
		return "notice.list";
	}
	
	@RequestMapping("detail")
	public String detail() {
		
		return "notice.detail";
	}
	
	/* 전달받을 파라미터 설정, 그 값의 기본값 설정, 타입을 자유롭게 지정 가능.
	
	@RequestMapping("list")
	public String list(@RequestParam(name = "p",defaultValue = "1") int page) throws ClassNotFoundException, SQLException {
//		String p = request.getParameter("p");
		System.out.println("page"+page);
		
		List<Notice> list = noticeService.getList(1, "TITLE", "");
		return "notice.list";
	}
	
	*/
	
	
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		
//		ModelAndView mv = new ModelAndView("notice.list");
////		mv.setViewName("/WEB-INF/view/notice/list.jsp");
//		List<Notice> list = noticeService.getList(1, "TITLE", "");
//		mv.addObject("list", list);
//		
//		return mv;
//	}

}

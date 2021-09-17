package com.springpractice.web.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springpractice.web.entity.Notice;
import com.springpractice.web.service.NoticeService;
import com.springpractice.web.service.jdbc.JDBCNoticeService;

public class ListController implements Controller{

	//1번 위치. 여기에 Autowired를 할 경우 하기 Autowired외에 무언가 처리될 수는 없음.
	//대신 1번 위치에 Autowired를 할 경우 하기 생성자는 필요 없음.
	private NoticeService noticeService;
	
	/*
	 * <!-- <property name="noticeService" ref="noticeService"/>  -->
	 * servlet-context에서 프로퍼티 설정을 해제하고 여기서 어노테이션으로 처리.
	 */
	@Autowired //2번 위치. 여기에 Autowired를 할 경우 이 생성자 실행시에 어떤 코드가 실행될때 같이 할 수 있음.
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ModelAndView mv = new ModelAndView("notice.list");
//		mv.setViewName("/WEB-INF/view/notice/list.jsp");
		List<Notice> list = noticeService.getList(1, "TITLE", "");
		mv.addObject("list", list);
		
		return mv;
	}

}

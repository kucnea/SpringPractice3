package com.springpractice.web.controller.api;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springpractice.web.entity.Notice;
import com.springpractice.web.service.NoticeService;

@RestController("apiNoticeController") // 얘가 있으면 method에 responseBody를 하지 않아도 글자로 반환하게 됨.
@RequestMapping("/api/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	
	@RequestMapping("list")
	public Notice list() throws ClassNotFoundException, SQLException {
		
		List<Notice> list = service.getList(1, "TITLE", "");
		
		return list.get(0);
	}	

	/*

	@RequestMapping("list")
	public String list() {
		
		return "공지사항 list";
	}	// NoticeController noticeController = new NoticeController
	// <bean id="noticeController" class="....NoticeController>
	// 이런식으로 지정하기 때문에, 상단의 ("apiNoticeController")를 추가해 이름을 다르게 명시해야함.
	 
	

	 */
}

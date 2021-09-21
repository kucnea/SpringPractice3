package com.springpractice.web.controller.admin.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice")
//@RestController("adminNoticeController") 이렇게 쓰지않고 바로 위에다 해도 됨.
public class NoticeController {

	@RequestMapping("list")
	public String list() {
		
		return "";
	}
	@RequestMapping("reg")
	@ResponseBody
	public String reg(String title, String content, String category, String[] foods, String food) {
		System.out.println(category);
		for(String f : foods) {
			System.out.println(f);
		}
		
		return String.format("title:%s<br>content:%s<br>category:%s<br>", title, content, category);
	}
	@RequestMapping("edit")
	public String edit() {
		
		return "";
	}
	@RequestMapping("del")
	public String del() {
		
		return "";
	}
}

package com.springpractice.web.controller.admin.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice")
//@RestController("adminNoticeController") 이렇게 쓰지않고 바로 위에다 해도 됨.
public class NoticeController {

	@Autowired
	private ServletContext ctx;
	
	@RequestMapping("list")
	public String list() {
		
		return "admin.board.notice.list";
	}
	
	//get 요청 처리
//	@RequestMapping("reg") 이전의 방식
	@GetMapping("reg")
	public String reg() {
		
		return "admin.board.notice.reg"; 
	}
	
	//post 요청 처리
//	@RequestMapping("reg") 이건 이전의 방식
//	@ResponseBody 문자열반환의 연습에서 view페이지를 쓸 것이기 때문에 주석
	@PostMapping("reg")
	public String reg(String title, String content, MultipartFile[] files, String category, String[] foods, String food, HttpServletRequest request) throws IllegalStateException, IOException {
		
//		if(request.getMethod().equals("POST")) {}로 묶어서 post일때와 아닐때를 구분 할 수도 있음
		
		for(MultipartFile file : files) {
		long size = file.getSize();
		String fileName = file.getOriginalFilename();
		
		System.out.printf("fileName:%s, fileSize:%d\n", fileName, size);
//		ServletContext ctx = request.getServletContext();
		String webPath = "/static/upload";
		String realPath = ctx.getRealPath(webPath);
		System.out.printf("realPath : %s\n", realPath);
		
//		업로드하기 위한 경로가 없을 경우
		File savePath = new File(realPath);
		if(!savePath.exists())
			savePath.mkdirs();
		
		
		realPath += File.separator + fileName;
		File saveFile = new File(realPath);
		
		file.transferTo(saveFile);
		
		}
		
		System.out.println(category);
		for(String f : foods) {
			System.out.println(f);
		}
		
		return "admin.board.notice.reg";
//		return String.format("title:%s<br>content:%s<br>category:%s<br>", title, content, category);
	}
	@RequestMapping("edit")
	public String edit() {
		
		return "admin.board.notice.edit";
	}
	@RequestMapping("del")
	public String del() {
		
		return "admin.board.notice.del";
	}
}

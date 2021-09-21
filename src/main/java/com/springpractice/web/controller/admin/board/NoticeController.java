package com.springpractice.web.controller.admin.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		
		return "";
	}
	@RequestMapping("reg")
	@ResponseBody
	public String reg(String title, String content, MultipartFile file, String category, String[] foods, String food, HttpServletRequest request) throws IllegalStateException, IOException {
		
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

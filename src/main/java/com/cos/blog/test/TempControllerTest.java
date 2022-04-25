package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

	@GetMapping("/temp/home")
	public String tempHome() {
		// 파일리턴 기본경로 : src/main/resources/static
		// static에는 정적인 파일만 사용 가능(ex : html, jpg 파일 .. / jsp 파일 사용 불가) 
		// 리턴명 : /home.html
		return "/home.html";
	}
	
	@GetMapping("/temp/img")
	public String img() {
		return "/구현화면3.jpg";
	}
	
	@GetMapping("/temp/jsp")
	public String jsp() {
		//prefix : /WEB-INF/views/
		//suffix : .jsp
		//풀네임 : /WEB-INF/views/test.jsp
		return "test"; 
	}
}

package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//사용자 요청->응답(HTML 파일)
//@Controller

//사용자 요청->응답(data)
@RestController
public class HttpControllerTest {
	
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		//Member m = new Member(1,"홍길동","1234","hong.naver.com");
		//빌더 장점 : 생성자 순서를 지키지 않아도 된다.
		Member m = Member.builder().username("홍길동").email("hong@naver.com").password("1234").build();
		System.out.println(m.getId());
		m.setId(123);
		System.out.println(m.getId());
		return "lombok Test 완료"+m.getId();
	}
	//인터넷 브라우저 요청은 무조건 get 요청
	//http://localhost:8080/http/get(select)
	/*
	 * @GetMapping("/http/get") public String getTest(@RequestParam int id, @RequestParam String username) {
	 * 
	 * return "get요청 : " + id + "," + username; }
	 */
	
	@GetMapping("/http/get")
	public String getTest(Member m) {//MessageConverter(스프링부트)
		
		return "get요청 : " + m.getId() + "," + m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	
	//http://localhost:8080/http/post(insert)
	@PostMapping("/http/post")//text/plain , application/json	
	public String postTest(@RequestBody Member m) {//MessageConverter(스프링부트)
		return "post요청 : " + m.getId() + "," + m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	
	//http://localhost:8080/http/put(update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put요청"+ m.getId() + "," + m.getUsername()+","+m.getPassword()+","+m.getEmail();
	}
	//http://localhost:8080/http/delete(delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete요청";
	}
}

package com.cos.blog.test;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Getter
//@Setter
@Data//Getter + Setter
//@AllArgsConstructor//생성자
//@RequiredArgsConstructor//final 붙은 변수의 생성자 만들어줌
@NoArgsConstructor//빈 생성자
public class Member {
	
	
	//객체지향에서는 변수를 private로 만들어서
	//변수에 직접 접근하지 못하게 한다.
	private int id;
	private String username;
	private String password;
	private String email;
	
	@Builder
	public Member(int id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	
}

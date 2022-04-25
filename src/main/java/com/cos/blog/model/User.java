package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder//빌더 패턴!
//ORM -> Java(다른 언어) Object -> 테이블에 매핑해주는 기술
@Entity// User클래스가 MY SQL에 테이블이 생성된다.
//@DynamicInsert//insert할때 null 인 필드 제외
public class User {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)// 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id; // 시퀀스, auto_increment
	
	@Column(nullable = false, length = 30, unique = true)
	private String username; //아이디
	
	@Column(nullable = false, length = 100)//123456 -> 해쉬(비밀번호 암호화)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;//myEmail => my_email : 다른 전략 사용했을 때(SpringPhysicalNamingStrategy(Default) )
	
//	@ColumnDefault("'user'") // '' 따옴표 필요
	//DB는 RoleType이라는 게 없다.
	@Enumerated(EnumType.STRING)
	private RoleType role; // Enum을 쓰는게 좋다. // admin, user, manager => 도메인 설정해줌
	
	@CreationTimestamp // 시간 자동 입력
	private Timestamp createDate;
}

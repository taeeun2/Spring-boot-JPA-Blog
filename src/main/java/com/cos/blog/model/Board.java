package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder//빌더 패턴!
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량 데이터
	private String content; // 섬머노트 라이브러리 <html>태그 섞여서 디자인이 됨
	
//	@ColumnDefault("0") // 숫자이기 때문에 ' 필요 없음
	private int count;//조회수
	
	@ManyToOne(fetch = FetchType.EAGER) // Board = Many, User = One
	@JoinColumn(name="userId")
	private User user; // DB는 오브젝트를 저장할 수 없다 -> FK 사용, 자바는 오브젝트를 저장할 수 있다.
	
	// Board = One, Reply = Many
	// FetchType : OneToMany일때는 보통은 LAZY이지만, 댓글을 모두 들고와 한 화면에 보여줘야 하므로 EAGER전략으로 바꿔줌
	@OneToMany(mappedBy = "board",fetch=FetchType.EAGER) // mappedBy 연관관계의 주인이 아니다(FK가 아님)=> DB에 컬럼을 만들지 마라는 뜻
	private List<Reply> reply; // reply 테이블의 board가 FK
	
	@CreationTimestamp //시간 자동 입력
	private Timestamp createDate;
	
	//join문 user+board+reply
}

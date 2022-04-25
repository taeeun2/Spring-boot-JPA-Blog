package com.cos.blog.test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController//데이터 응답
public class DummyControllerTest {
	
	@Autowired//의존성 주입(DI)
	private UserRepository userRepository;
	
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		/*
		try {
			userRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			return "삭제에 실패하였습니다. 해당 id는 DB에 없습니다.";
		}
		*/
		
		try {
			userRepository.deleteById(id);
		}catch(Exception e) {//최고 부모인 Exception해도 됨 (정확히는 EmptyResultDataAccessException)
			return "삭제에 실패하였습니다. 해당 id는 DB에 없습니다.";
		}
		return "삭제되었습니다.id : "+id;
	}
	//save함수는 id를 전달하지 않으면 insert해줌
	//		   id를 전달하고, 해당 id에 대한 데이터가 있으면 update해줌
	// 		   id를 전달하고, 해당 id에 대한 데이터가 없으면 insert해줌
	@Transactional // 함수 종료 시 자동으로 commit이 됨 , 변경 감지 -> 데이터 베이스 수정
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id,@RequestBody User requestUser) {//json으로 데이터를 받기 위해서는 RequestBody 필요
		System.out.println("id : " + id);										// json데이터 요청 => Java Object(MessageConverter의 Jackson라이브러리가 변환해서 받아줌)
		System.out.println("password : "+requestUser.getPassword());
		System.out.println("email : "+ requestUser.getEmail());
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		//save는 원래 insert에 쓰임
		//Transactional을 걸면 save를 사용하지 않아도 update가 됨
		//userRepository.save(requestUser);
		
		//더티 체킹
		return user;
	}
	
	@GetMapping("/dummy/users")
	public List<User> list(){
		return userRepository.findAll();
	}
	
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size = 2, sort ="id",direction = Sort.Direction.DESC)Pageable pageable){
		Page<User> pagingUser = userRepository.findAll(pageable);
		
		//if(pagingUser.isLast())
		List<User> users =  pagingUser.getContent();
		return users;
	}
	//{id}주소로 파라메타를 전달할 수 있음.
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		
		// id로 찾은 user가 NULL일 경우, 에러 메시지 출력
		// NULL이 반환될 상황이 없을 경우 userRepository.findById(id).get();
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {

			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 유저는 없습니다. id : "+id) ;
			}
		});
		
		//람다식
		/*
		User user2 = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 사용자는 없습니다.");
		});
		*/
		
		// 요청 : 웹브라우저
		// user 객체 : 자바 오브젝트
		// 변환 (웹브라우저가 이해할 수 있는 데이터) -> json(Gson 라이브러리)
		// 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서
		// user 오브젝트를 json으로 변환해서 브라우저에게 던져줍니다.
		return user;
		
	}
	
	
	//http의 body에 username,password,email 데이터를 가지고(요청)
	@PostMapping("/dummy/join")
	public String join(User user) {//key=value(약속된 규칙)
		
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
	}
}

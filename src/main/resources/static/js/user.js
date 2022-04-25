/*jQuery*/
let index = {
	init:function(){
		$("#btn-save").on("click",()=>{ //this를 바인딩하기 위해서
			this.save();
		});
		
		
		/*$("#btn-login").on("click",()=>{ //this를 바인딩하기 위해서
			this.login();
		});*/
		
		$("#btn-update").on("click",()=>{ //this를 바인딩하기 위해서
			this.update();
		});
	},
	
	save:function(){
		let data={
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val()
		};
		
		//ajax호출 시 default가 비동기 호출
		// ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!
		$.ajax({
			//회원가입 수행 요청(100초 가정)
			type: "POST",
			url:"/auth/joinProc", // method가 post면 insert이기 때문에 join을 적어주지 않아도 된다.
			data:JSON.stringify(data),//http body 데이터
			contentType:"application/json;charset=utf-8",//body데이터가 어떤 타입인지(MIME)
			dataType:"json"//요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열/생긴게 json이라면=>javascript 오브젝트로 변경	
		}).done(function(resp){
			
			alert("회원가입이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
		
	},
	
	/*login:function(){
		let data={
			username:$("#username").val(),
			password:$("#password").val(),
		};
		
		$.ajax({
			type: "POST",
			url:"/api/user/login", // method가 post면 insert이기 때문에 join을 적어주지 않아도 된다.
			data:JSON.stringify(data),//http body 데이터
			contentType:"application/json;charset=utf-8",//body데이터가 어떤 타입인지(MIME)
			dataType:"json"//요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열/생긴게 json이라면=>javascript 오브젝트로 변경	
		}).done(function(resp){
			alert("로그인이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
		
	}*/
	
	update:function(){
		let data={
			id:$("#id").val(),
			username:$("#username").val(),
			password:$("#password").val(),
			email:$("#email").val()
		};
		
		$.ajax({
			type: "PUT",
			url:"/user",
			data:JSON.stringify(data),
			contentType:"application/json;charset=utf-8",
			dataType:"json"
		}).done(function(resp){
			alert("회원수정이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
		
	},
}

index.init();
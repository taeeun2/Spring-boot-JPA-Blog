<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@ include file="../layout/header.jsp"%>

<div class="container">
	<h2>�α���</h2>
 <!-- form action�� ����ϱ� ���ؼ��� name �ʿ� -->
 <form action = "/auth/loginProc" method="post">
    <div class="form-group">
      <label for="username">Username</label>
      <input type="text" class="form-control" id="username" placeholder="Enter username" name="username">
    </div>
    
    <div class="form-group">  
      <label for="password">Password</label>
      <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
    </div>
    
    <!-- <div class="form-group form-check">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember"> Remember me
      </label>
    </div> -->
    
   	<button id = "btn-login" class="btn btn-primary">�α���</button>  
	<a href="https://kauth.kakao.com/oauth/authorize?client_id=af316f3ef6c41eca4d69420bddbb9f87&redirect_uri=http://localhost:8000/auth/kakao/callback&response_type=code"><img height ="38px" src="/image/kakao_login_button.png"/></a>
  </form>

<!-- Ajax ��� �� -->
<!-- 	<button id = "btn-login" class="btn btn-primary">�α���</button>-->  
</div>

<!-- <script src = "/js/user.js"></script>-->
<%@ include file="../layout/footer.jsp"%>



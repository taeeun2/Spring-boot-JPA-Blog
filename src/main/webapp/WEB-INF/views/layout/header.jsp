<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ������ ��ť��Ƽ �±�-->
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %><!DOCTYPE html>
<sec:authorize access="isAuthenticated()">
 	<!-- principal : ���� user object�� ������ �� �ְ� ���� -->
	<sec:authentication property="principal" var ="principal"/>
	
</sec:authorize>

<html lang="en">
<head>
<title>Tae-eun BLOG</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script
	src="https://c dn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
 <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
<body>

	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<a class="navbar-brand" href="/">Ȩ</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">

			<c:choose>
				<c:when test="${empty principal}">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link"
							href="/auth/loginForm">�α���</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/auth/joinForm">ȸ������</a></li>
					</ul>
				</c:when>
				<c:otherwise>

					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link"
							href="/board/saveForm">�۾���</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/user/updateForm">ȸ������</a></li>
						<li class="nav-item"><a class="nav-link"
							href="/logout">�α׾ƿ�</a></li>	
					</ul>
				</c:otherwise>
			</c:choose>





		</div>
	</nav>
	<br />
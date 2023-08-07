<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타임라인</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/timelineStyle.css">
</head>
<body>
	
	<div id="wrap" class="container-fluid">
		<header class="position-fixed h-100">
			<div class="my-4">
				<h2>Hm</h2>
			</div>
			<nav>
				<ul class="nav flex-column mr-4">
					<li class="nav-item mt-2"><a class="nav-link text-dark" href="#">홈</a></li>
					<li class="nav-item mt-2"><a class="nav-link text-dark" href="#">만들기</a></li>
					<li class="nav-item mt-2"><a class="nav-link text-dark" href="#">프로필</a></li>
				</ul>
			</nav>
			<div class="fixed-bottom ml-3">
				<c:if test="${not empty userId}">	
				<div class="mr-3">
					${userName}<a class="text-dark nav-link" href="/user/logout">로그아웃</a>	
				</div>
				</c:if>
				
			</div>
		</header>
		<section class="contents mx-auto">
			<div>
				<div class="d-flex">
					<div>img</div>
					<div>id</div>
				</div>
				<div>
					<div class="test-img"></div>
				</div>
				<div class="d-flex">
					<div>heart</div>
					<div>comment</div>
				</div>
				<div>좋아요 2개</div>
				<div>
					<div><b>nickname</b> 텍스트 텍스트 텍스트</div>
					<div>더 보기</div>
				</div>
				<div>
					<div>comment_Input</div>
					<div class="d-flex">
						<input><div>add</div>
					</div>
				</div>
			</div>
			<div class="bg-">
				<div class="d-flex">
					<div>
						<div>img</div>
						<div>Id</div>
					</div>
					<div>공유하기</div>
				</div>
				<div class="d-flex">
					<div>사진선택</div>
					<div>
						<textarea rows="5" cols="20"></textarea>
					</div>
				</div>
			</div>
		</section>
		
	</div>

	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
				
		});
	
	</script>
</body>
</html>
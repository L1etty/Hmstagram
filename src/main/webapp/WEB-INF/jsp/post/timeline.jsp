<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타임라인</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
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
			<div id="post-created-view" class="d-flex justify-content-center align-items-center">
					<div class="border mt-5" id="post-created-box">
						<div class="m-2">
							<div class="d-flex justify-content-between mb-2">
								<div class="d-flex">
									<div>img</div>
									<div>${userName}</div>
								</div>
								<a id="creatBtn" class="text-primary">공유하기</a>
							</div>
							<div class="d-flex align-items-end">
								<div class="align-items-end">
									<i class="bi bi-card-image image-icon" id="imageIcon"></i>
								</div>
								<input type="file" class="d-none" id="fileInput">
								<div>
									<textarea rows="5" cols="20" id="contentInput" class="border-0"></textarea>
								</div>
							</div>
						</div>
					</div>
				</div>
				
			<c:forEach var="postList" items="${postList}" >
				<div class="timeline-post my-3 pb-3">
					<div class="d-flex">
						<div class="mr-3">○</div>
						<div>${postList.userName}</div>
					</div>
					<div class="img-box">
						<img src="${postList.contentImagePath}" class="img-fluid">
					</div>
					<div class="d-flex py-2">
						<i class="bi bi-heart likeBtn" data-post-id="${postList.id}"></i>
						<i class="bi bi-hand-thumbs-up"></i><div>좋아요 2개</div>
					</div>
					
					<div class="w-100">
						<div><b>${postList.userName}</b> ${postList.content}</div>
					</div>
					<div class="comment-box small">
						<div class="my-2">
							<div>댓글 보기</div>
						</div>
						
						<div class="d-flex justify-content-between">
							<input class="commentInput col-10 p-0" placeholder="댓글 달기..."><div class="commentBtn text-primary mr-3">게시</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</section>
		
		
	</div>

	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function() {
			
			$(".likeBtn").on("click", function() {
				
				var postId = $(this).data("post-id");
				
				$.ajax({
					type:"post"
					,url:"/post/like"
					,data:{"postId":postId}
					,success:function(data){
				 		alert(data.result);
				 	}
					,error:function(){
						alert("에러");
					}
					
				});
				
			});
			
			$("#imageIcon").on("click", function() {
				$("#fileInput").click();
			});
			
			$("#creatBtn").on("click", function() {
				
				let file = $("#fileInput")[0];
	
				let content = $("#contentInput").val();
				
				if(file.files.length == 0){
					alert("파일을 넣어주세요.");
					return false;
				}
				
				if(content == ""){
					alert("내용을 입력해주세요");
					return false;
				}
				
				var formData = new FormData();
				formData.append("contentImagePath", file.files[0]);
				formData.append("content", content);
				
 				$.ajax({
					type:"post"
					,url:"/post/create"
					,data:formData
					,enctype:"multipart/form-data" // 파일 업로드 옵션
					,processData:false // 파일 업로드 옵션
					,contentType:false  // 파일 업로드 옵션
					,success:function(data){
						if(data.result = "success"){
							location.href = "/post/timeline";
							alert("저장성공");
						}else{
							alert("저장실패");
						}
					}
					,error:function(){
						alert("저장에러");
					}
				});
				
			});
			
		});
	</script>
</body>
</html>
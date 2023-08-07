<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css">
</head>
<body>

	<div id="wrap">
		<section class="contents d-flex justify-content-center mt-5">
			<div class="join-box mt-2">
				<div class="text-center mb-4">
					<h2 class="mb-0">Hm</h2>
					<small class="text-secondary">친구들의 사진과 동영상을 보려면 가입하세요.</small>
				</div>
				<div>
					<div class="input-group">
						<input type="text" placeholder="아이디" class="form-control col-9" id="idInput"><button class="btn btn-sm btn-primary col-3" id="confirmBtn">중복확인</button>
					</div>
					<input type="text" placeholder="성명" class="form-control mt-2" id="userNameInput">
					<input type="text" placeholder="별명" class="form-control mt-2" id="nickNameInput">
					<input type="password" placeholder="비밀번호" class="form-control mt-2" id="passwordInput">
					<input type="password" placeholder="비밀번호 확인" class="form-control mt-2" id="passwordConfirmInput">
					<button class="btn btn-primary btn-block my-3" id="joinBtn">가입</button>
					<div class="d-flex justify-content-center">
						<div class="col-sm-5 mr-2"><hr class="line"></div>
						<div class="col-auto">또는</div>
						<div class="col-sm-5 ml-2"><hr class="line"></div>
					</div>
					<div class="d-flex justify-content-center">
						<div class="mr-2">계정이 있으신가요?</div><a href="/user/login-view">로그인</a>
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
			
			var duplicate = false;
			
			$("#idInput").on("change", function() {
				duplicate = false;
			});
			
			$("#confirmBtn").on("click", function() {
				
				let id = $("#idInput").val();
				
				if(id == ""){
					alert("아이디를 입력해주세요.");
					return false;
				}
				
				
				$.ajax({
					type:"get"
					,url:"/user/duplicate-id"
					,data:{"loginId":id}
					,success:function(data){
						if(data.isDuplicate == "false"){
							alert("중복 아님 사용가능");
							duplicate = true;
						}else{
							alert("중복된 아이디 다른 아이디를 입력하세요.");
							duplicate = false;
						}
					}
					,error:function(){
						alert("중복확인 에러");
					}
				});
				
			});
			
			$("#joinBtn").on("click", function() {
				let id = $("#idInput").val();
				let userName = $("#userNameInput").val();
				let nickName = $("#nickNameInput").val();
				let password = $("#passwordInput").val();
				let passwordConfirm = $("#passwordConfirmInput").val();
				
				if(duplicate == false){
					alert("아이디 중복검사를 해주세요.");
					return false;
				}
				
				if(userName == ""){
					alert("성명을 입력하세요.");
					return false;
				}
				
				if(nickName == ""){
					alert("별명을 입력하세요.");
					return false;
				}
				if(password == ""){
					alert("비밀번호를 입력하세요.");
					return false;
				}
				
				if(password != passwordConfirm){
					alert("패스워드가 같지 않습니다.");
					return false;
				}
				
				$.ajax({
					type:"post"
					,url:"/user/join"
					,data:{"loginId":id, "password":password, "userName":userName, "nickName":nickName}
					,success:function(data){
						if(data.result == "success"){
							location.href = "user/login-view";
						}else{
							alert("회원가입 실패");
						}
					}
					,error:function(){
						alert("회원가입 에러");
					}
					
				});
				
			});
			
		});
	</script>
</body>
</html>
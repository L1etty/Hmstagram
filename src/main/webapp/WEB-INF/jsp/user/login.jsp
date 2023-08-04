<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css">
</head>
<body>
	
	<div id="wrap">
		<section class="contents d-flex justify-content-center mt-5">
			<div class="join-box mt-2">
				<div class="text-center mb-4">
					<h2 class="mb-0">Hm</h2>
				</div>
				<div>
					<div class="input-group">
						<input type="text" placeholder="아이디" class="form-control" id="idInput">
					</div>
					<input type="password" placeholder="비밀번호" class="form-control mt-2" id="passwordInput">
					<button class="btn btn-primary btn-block my-3" id="joinBtn">로그인</button>
					<div class="d-flex justify-content-center">
						<div class="col-sm-5 mr-2"><hr class="line"></div>
						<div class="col-auto">또는</div>
						<div class="col-sm-5 ml-2"><hr class="line"></div>
					</div>
					<div class="d-flex justify-content-center">
						<div class="mr-2">계정이 없으신가요?</div><a href="/user/join-view">가입하기</a>
					</div>
					<div class="text-center small"><a href="#" class="text-secondary">비밀번호를 잊으셨나요?</a></div>	
				</div>
			</div>
		</section>
	</div>

	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
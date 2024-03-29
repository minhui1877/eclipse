
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>강의 평가 웹 사이트</title>
<!-- 부트스트랩 CSS추가하기 -->
<link rel="stylesheet" href="./css/bootstrap.min.css">
<!-- 커스텀 CSS추가하기 -->
<link rel="stylesheet" href="./css/custom.css">
</head>
<body>
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
   <a class="navbar-brand" href="index.jsp">강의 평가 웹사이트</a>
   <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar">
     <span class="navbar-toggle-icon"></span>
   </button>
   <div class="collapse navbar-collapse" id="navbar">
     <ul class="navbar-nav mr-auto">
     <li class="nav-item active">
     <a class="nav-link" href="index.jsp">메인</a>
     </li>
     <li class="nav-item dropdown">
     <a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">
     회원관리</a>
     <div class="dropdown-menu" aria-labelledby="dropdown">
       <a class="dropdown-item" href="userLogout.jsp">로그아웃</a>
     </div>
     </li>
     </ul>
     <form action="./index.jsp" method="get" class="form-inline my-2 my-lg-0">
     <input type="text" name="search" class="form-control mr-sm-2" placeholder="내용을 입력하세요.">
     <button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색 </button>
     </form>
   </div>
 </nav>
 <div class="container">
    <div class="alert alert-warning mt-4" role="alert">
    이메일 주소 인증을 하셔야 이용 가능 합니다. 인증 메일을 받지 못하셨나요?
    </div>
    <a href="emailSendAction.jsp" class="btn btn-primary"> 인증메일 다시받기 </a>
 </div>
 <footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;" >
   Copyright ⓒ 2019 민슈가 짱짱맨 뿡뿡 All Right Reserved.
 </footer>
 <!-- 제이쿼리 자바스크립트 추가하기 -->
 <script src="./js/jquery.min.js"></script>
  <!-- Popper 자바스크립트 추가하기 -->
 <script src="./js/popper.min.js"></script>
  <!-- 부트스트랩 자바스크립트 추가하기 -->
 <script src="./js/bootstrap.min.js"></script>
</body>
</html>
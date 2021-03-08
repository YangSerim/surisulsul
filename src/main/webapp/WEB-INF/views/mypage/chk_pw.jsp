<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- JSTL로 변수 생성 --%>
<%-- 1) 캐시를 방지하기 위해 자주 수정되는 css,js 파일에 설정하는 용도 --%>
<c:set var="currentTime" value="<%=System.currentTimeMillis()%>" />
<%-- 2) 프로젝트이름 기반의 절대경로값 --%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<!doctype html>
<html>

<head>
<meta charset="UTF-8" />
<title>surisulsul</title>
<!-- 크로스 브라우징 호환성 시작 -->
<link rel="stylesheet" type="text/css" href="${contextPath}/assets/css/reset.css" />
<!-- 크로스 브라우징 호환성 끝 -->
<!-- CSS 파일 참조 처리 -->
<link rel="stylesheet" type="text/css" href="${contextPath}/assets/css/common.css?time=${currentTime}" />
 <link rel="stylesheet" type="text/css" href="${contextPath}/assets/css/join.css?time=${currentTime}" />
 <link rel="stylesheet" type="text/css" href="${contextPath}/assets/css/popup.css?time=${currentTime}" />
 <link rel="stylesheet" type="text/css" href="${contextPath}/assets/plugins/sweetalert/sweetalert2.min.css?time=${currentTime}" />
 </head>
<body>

  <div class="chk-pw-box">
        <div class="box-title">
            비밀번호 확인
        </div>
        <span class="box-alert">회원정보 수정을 위해<br />비밀번호를 한 번 더 입력해 주세요.</span>
        <form name="chk_pw" action="${pageContext.request.contextPath}/chk_pw" id="chk_pw">
        <div class="input-pw-box">
            <label for="chk-pw col-md-4">비밀번호</label>
            <input type="password" name="chk-pw" id="chk-pw" placeholder="비밀번호를 입력해주세요." />
        </div>
        <div>
            <button type="submit">확인</button>
        </div>
        </form>
    </div>
    <!--Google CDN 서버로부터 jQuery 참조 -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- jQuery Ajax Form plugin CDN -->
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery.form/4.2.2/jquery.form.min.js"></script>
    <!-- jQuery Ajax Setup -->
    <script src="${pageContext.request.contextPath}/assets/plugins/ajax/ajax_helper.js"></script>
    <script src="${contextPath}/assets/plugins/sweetalert/sweetalert2.min.js?time=${currentTime}" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
    $(function() {
    	 // #addForm에 대한 submit이벤트를 가로채서 Ajax요청을 전송한다.
        $("#chk_pw").ajaxForm({
            // 전송 메서드 지정
            method: "POST",
            // 서버에서 200 응답을 전달한 경우 실행됨
            success: function(json) {
                console.log(json);
                
                // json에 포함된 데이터를 활용하여 상세페이지로 이동한다.
                if (json.result == "OK") {
                	swal({
	                    title: "비밀번호 확인",
	                    text: "비밀번호 확인이 완료되었습니다.",
	                    type: "success"
	                }).then((value)=>{
	           
	                		window.opener.location.href="${pageContext.request.contextPath }/mypage/update_info.do";
	                		window.close();	                	
	                	});                   
                } else {
                	swal({
	                    title: "비밀번호 확인",
	                    text: "입력하신 비밀번호가 올바르지 않습니다.",
	                    type: "warning"
	                });
					$("#chk-pw").val("");
					$("#chk-pw").focus();
                }
            }
        }); // 여기가 끝
	});
    </script>
      </body>

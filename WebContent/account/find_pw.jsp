<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8" />
    <title>비밀번호 찾기</title>
</head>

<body>
    <h3>비밀번호 찾기</h3>
    <span>
        <p>가입 시 입력한 비밀번호를 잊으셨나요?<br />
            수리술술에 가입한 이름, 핸드폰 번호, 이메일을 정확히 입력해 주세요.</p>
    </span>
    <!-- 비밀번호 재발급에 필요한 정보를 입력하는 폼 : 데이터 조회(where) 조건 -->
    <!-- 형식 검사 할 것인지? -->
    <form class="form-horizontal" name="join_form" id="join_form">
        <div class="form-group">
            <label for='user_name' class="col-md-2">이름 <span class='identify'>*</span></label>
            <div class="col-md-10">
                <input type="text" name="user_name" id="user_name" class="form-control" placeholder="이름을 입력하세요." />
            </div>
        </div>
        <div class="form-group">
            <label for='tel' class="col-md-2">전화번호 <span class='identify'>*</span></label>
            <div class="col-md-10">
                <input type="tel" name="tel" id="tel" class="form-control" placeholder="휴대폰 번호를 - 없이 입력하세요." />
            </div>
        </div>
        <div class="form-group">
            <label for="email" class="col-md-2">이메일<span class="identify">*</span></label>
            <div class="col-md-10">
                <input type="email" name="email" id="email" class="form-control" placeholder="이메일을 입력하세요." />
            </div>
        </div>
        <div class="form-group">
            <div class="text-center">
                <button type="submit">새 비밀번호 발급</button>
            </div>
        </div>
    </form>
    <div class="print_email">
        <p>새 비밀번호가 고객님의 이메일로 발급되었습니다.</p>
        <!-- 조회하기 전일 시 해당 블록에 아무런 텍스트도 뜨지 않게 할 것 -->
        <!-- 해당하는 정보가 없어 조회에 실패할 경우 사이트에 등록된 이메일이 없습니다. 입력한 정보를 다시 확인해 주세요. 라는 문구로 변경해서 나오게 할 것 -->
        <!-- 데이터 조회에 성공할 시 받아온 이메일 데이터로 메일을 전송하고 비밀번호를 자동으로 수정할 것 -->
    </div>
</body>

</html>
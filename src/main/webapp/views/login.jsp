<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="login" method="post">
		<h2>Đăng nhập tài khoản</h2>
		<c:if test="${alert !=null}">
			<h3 class="alert alert danger">${alert}</h3>
		</c:if>

		<section>
			<label class="input login-input">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fauser"></i></span> <input
						type="text" placeholder="Tài khoản" name="username"
						class="form-control"> <br> <input type="text"
						placeholder="Mật khẩu" name="password" class="form-control">
					<br> <input type="Submit" value="Submit" /> <input
						type="checkbox" value="remember" /> Ghi nhớ đăng nhập
				</div>
			</label>
		</section>
		<a href="${pageContext.request.contextPath }/forget">Quên mật khẩu
							</a>
	</form>

</body>
</html>
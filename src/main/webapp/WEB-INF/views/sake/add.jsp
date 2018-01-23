<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form modelAttribute="sake">
		<dl>
			<dt>브랜드</dt>
			<dd>
				<form:input path="brand"></form:input>
			</dd>
			<dt>타입</dt>
			<dd>
				<form:select path="sakeType.id" items="${sakeTypes}" itemLabel="type" itemValue="id"></form:select>
			</dd>
		</dl>
		<input type="submit" value="추가"></input>
	</form:form>
	${result}
</body>
</html>
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
	<h3>sake 상세</h3>
	사케 ID : ${sake.id}
	<br> 브랜드 : ${sake.brand}
	<br> 타입 : ${sake.sakeType.type}
	<br> 감상
	<c:forEach var="imp" items="${sake.impressions}">
		<li>${imp.temperature.temp} : ${imp.impression}</li>
	</c:forEach>

	<!-- action은 타겟 페이지 write-->
	<form:form modelAttribute="impression" action="${pageContext.request.contextPath}/sake/writeimp">
	<input type="hidden" name="sake_id" value="${sake.id}">
		<form:select path="temperature.id" items="${temperature}"
			itemLabel="temp" itemValue="id"></form:select>
		<form:textarea path="impression" />
		<input type="submit" value="쓰기"></input>
	</form:form>
</body>
</html>
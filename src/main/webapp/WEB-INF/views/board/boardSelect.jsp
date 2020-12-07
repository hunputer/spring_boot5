<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/bootstrap.jsp"></c:import>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1>num : ${vo.num}</h1>
	<h1>writer : ${vo.writer}</h1>
	<h1>contents : ${vo.contents}</h1>
	<c:forEach items="${vo.file}" var="file">
		<a href="./noticeFileDown?fnum=${file.fnum}">${file.fileName}</a>
	</c:forEach>
</body>
</html>
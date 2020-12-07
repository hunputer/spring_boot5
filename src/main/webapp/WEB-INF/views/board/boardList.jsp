<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<style type="text/css">
	 .c1{
	 	cursor : pointer;
	 }
	</style>
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<div class="container">
  <h3>notice List</h3>
  
  <img alt="" src="../images/logo.png">
  <div class="row">
  <div class="col-sm-5">
  <form id="searchForm" action="./${board}List">
  	<input type="hidden" name="curPage" id="curPage" value="1">
       <div class="input-group">
        <select class="input-group-sm" id="kind" name="kind">
        	<option value="title">Title</option>
        	<option value="writer">Writer</option>
        	<option value="con">Contents</option>
        </select>
        <input id="search" type="text" class="form-control" name="search" placeholder="Additional Info">
        <div class="input-group-btn">
              <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
              </button>
        </div>
      </div>
      
  </form>
  </div>
  </div>
  
  <table class="table table-hover">
  	<tr>
  		<td>Num</td>
  		<td>Title</td>
  		<td>Writer</td>
  		<td>Date</td>
  		<td>Hit</td>
  	</tr>
  	
  	<c:forEach items="${list}" var="dto">
  		<tr>
  			<td>${dto.num}</td>
  			<td><a href="./${board}Select?num=${dto.num}">${dto.title}</a></td>
  			<td>${dto.writer}</td>
  			<td>${dto.regDate}</td>
  			<td>${dto.hit}</td>
  		</tr>
  	</c:forEach>
  </table>
  
  <!-- Page -->
  <ul class="pagination">
  	  <c:if test="${pager.before}">
  	  	<li><a href="#" class="list" title="${pager.startNum-1}">Before</a></li>
  	  </c:if>
	  <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
	  	<li><a href="#" class="list" title="${i}">${i}</a></li>
	  </c:forEach>
	  <c:if test="${pager.after}">
  	  	<li><a href="#" class="list" title="${pager.lastNum+1}">After</a></li>
  	  </c:if>
  </ul>
  
  
  <a href="./${board}Write">Write</a>
  
  
  <script type="text/javascript">
  $(".list").click(function(){
		var curPage = $(this).attr("title");
		$("#curPage").val(curPage);
		$("#searchForm").submit();
	});
  </script>
</div>
</body>
</html>
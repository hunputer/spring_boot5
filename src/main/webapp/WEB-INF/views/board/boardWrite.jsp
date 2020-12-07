<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<div class="container">
   <h1>board write</h1>   
<form action="./${board}Write" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="text">title:</label>
      <input type="text" class="form-control" id="title" placeholder="Enter title" name="title">
    </div>
    <div class="form-group">
      <label for="writer">writer:</label>
      <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer">
    </div>
    <div class="form-group">
  <label for="contents">contents</label>
  <textarea class="form-control" rows="5" id="contents" name="contents"></textarea>
  
  <div class="form-group">
      <label for="files">file:</label>
      <input type="file" class="form-control" id="files" name="files">
      <input type="file" class="form-control" id="files" name="files">
   </div>
</div>
    <button type="submit" class="btn btn-default">Submit</button>
  </form>
</div>
</body>
</html>
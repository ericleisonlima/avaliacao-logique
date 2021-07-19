<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<<jsp:useBean id="linkView" class="view.LinkView"></jsp:useBean>
<%@ page language="java" contentType="text/html; charsert=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Projeto Avaliativo</title>
<style type="text/css">
	.main{
		width: 700px;
		margin: auto;
	}
	form{
		margin: 1rem 0;
	}
	tabel{
		width: 100%;
	}
</style>
</head>
<body>
	
	
	<div class="main">
		<h1>Encurtador de URL</h1>
		<form action="InsertUrlController" method="POST">
			<input type="url" required="required" name="url">
			<input type="submit" value="Create URL">
		</form>
		
		
		<table border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>URL</th>
					<th>Code</th>
					<th>Custom</th>
				</tr>
			</thead>
			<tbody>
			
		
				<c:forEach items="${linkView.getLinks()}" var="link">
					<tr>
						<td>${link.getId()}</td>
						<td>${link.getUrl()}</td>
						<td><a href="http://localhost:8080/avaliacao-logique/@${link.getCode()}"></a></td>
						<td>${link.getCustom()}</td>
					</tr>
				
				</c:forEach>
			
			
			</tbody>
		
		</table>
	
	</div>
</body>
</html>
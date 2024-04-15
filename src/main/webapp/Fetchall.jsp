<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="dao.MoviesDao"%>
<%@page import="dto.Movies"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all movies</title>
</head>
<body>
	<%
	List<Movies> list = (List<Movies>) request.getAttribute("list");
	/* Movies dao = new Movies(); */
	%>

	<h1 align='center'>Movies Details</h1>
	<table border="1px" align='center'>
		<tr>
			<th>Name</th>
			<th>Language</th>
			<th>Genre</th>
			<th>Rating</th>
			<th>Image</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
		for (Movies mo : list) {
		%>
		<tr>
			<td><%=mo.getName()%></td>
			<td><%=mo.getLanguage()%></td>
			<td><%=mo.getGenre()%></td>
			<td><%=mo.getRating()%></td>
			<td><img height="140px" width="160px" alt="<%=mo.getName()%>"
				src="data:image/jpeg;base64,<%=Base64.encodeBase64String(mo.getImg())%>"></td>
			<td>
				<button>Edit</button>
			</td>
			<td><a href="delete-movie?id=<%=mo.getId()%>"><button>Delete</button></a>
			</td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<div align='center'>
		<a href="home.html">
			<button>Back</button>
		</a>
	</div>
</body>
</html>
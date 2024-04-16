<%@page import="org.apache.commons.codec.binary.Base64"%>
<%@page import="dao.MoviesDao"%>
<%@page import="dto.Movies"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View all movies</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

h1 {
	text-align: center;
	margin-top: 20px;
}

table {
	width: 80%;
	margin: 20px auto;
	border-collapse: collapse;
	background-color: #fff;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

th, td {
	padding: 12px 15px;
	text-align: center;
	border-bottom: 1px solid #ddd;
}

th {
	background-color: #f2f2f2;
}

tr:hover {
	background-color: #f2f2f2;
}

img {
	display: block;
	margin: auto;
}

button {
	padding: 8px 15px;
	background-color: #4CAF50;
	color: white;
	border: none;
	cursor: pointer;
	border-radius: 4px;
	transition: background-color 0.3s;
}

button:hover {
	background-color: #45a049;
}

a {
	text-decoration: none;
}

.btn-container {
	text-align: center;
	margin-top: 20px;
}
</style>
</head>
<body>
	<%
	List<Movies> list = (List<Movies>) request.getAttribute("list");
	/* Movies dao = new Movies(); */
	%>
	<h1>Movies Details</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Language</th>
				<th>Genre</th>
				<th>Rating</th>
				<th>Image</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
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
				<td><button>Edit</button></td>
				<td><a href="delete-movie?id=<%=mo.getId()%>"><button>Delete</button></a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<div class="btn-container">
		<a href="home.html"><button>Back</button></a>
	</div>
</body>
</html>
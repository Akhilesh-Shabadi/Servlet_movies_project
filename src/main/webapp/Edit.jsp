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
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.container {
	background-color: #fff;
	padding: 18px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	max-width: 500px;
	width: 100%;
}

div {
	display: flex;
	justify-content: center;
}

h1 {
	text-align: center;
	margin-bottom: 20px;
}

form {
	display: flex;
	flex-direction: column;
}

label {
	margin-bottom: 10px;
	font-weight: bold;
}

input[type="text"], input[type="file"], input[type='number'], select[name='language'],
	select[name='genre'], img {
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	text-align: center;
}

input[type="file"] {
	padding: 5px;
}

input[name='id'] {
	background-color: rgb(0, 0, 0, 0.1);
}

button {
	padding: 10px;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	margin-bottom: 5px;
}

a {
	margin: 0;
	padding: 0;
	background-color: #007bff;
	color: #fff;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

button:hover, a:hover {
	background-color: #0056b3;
}
</style>
</head>
<body align=center>
	<%
	Movies movies = (Movies) request.getAttribute("list");
	/* Movies movies=(Movies) list; */
	/* for (Movies movies : list) { */
	%>
	<h1>Update Field</h1>
	<div>
		<form action="updating-movie" method="post"
			enctype="multipart/form-data">
			ID: <input readonly="readonly" value="<%=movies.getId()%>" name="id"
				type="number"> <br> <br> Update Name? : <input
				value="<%=movies.getName()%>" type="text" name="name"> <br>
			<br> Update Language? : <select id="language" name="language">
				<option value="<%=movies.getLanguage()%>"><%=movies.getLanguage()%></option>
				<option>English</option>
				<option>Hindi</option>
				<option>Kannada</option>
			</select> <br> <br> Update Rating?: <input
				value="<%=movies.getRating()%>" type="text" name="rating"> <br>
			<br> Update Genre? : <select id="genre" name="genre">
				<option value="<%=movies.getGenre()%>"><%=movies.getGenre()%></option>
				<option>Horror</option>
				<option>Comedy</option>
				<option>Action</option>
				<option>Thriller</option>
			</select> <br> <br> Image : <input type="file" id="image"
				name="image"> <img height="140px" width="160px"
				alt="<%=movies.getImg()%>"
				src="data:image/jpeg;base64,<%=Base64.encodeBase64String(movies.getImg())%>">
			<br> <br>
			<button>Update</button>
			<a href="javascript:history.back()" class="back-button"><button
					type="button">Back</button></a>
		</form>
	</div>
	<%-- <%
	return;
	}
	%> --%>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  Controller message: ${msg} </P>

<form action="/Library/">
<input type="submit" value="Back"/>
</form>
</body>
</html>

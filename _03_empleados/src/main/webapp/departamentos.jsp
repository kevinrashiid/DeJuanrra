<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<form action="EmpleadosServlet">
			Seleccione departamento:
			<select name="departamento">
				<%List<String> depars=(List<String>)request.getAttribute("departamentos");
				for(String d:depars){%>
					<option value="<%=d%>"><%=d%></option>
				<%}%>
			</select>
			<br><br>
			<input type="submit" value="ver empleados">
		
		
		</form>
	</center>
</body>
</html>
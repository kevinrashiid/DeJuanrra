<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,model.Empleado"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Empleados del departamento: <%=request.getAttribute("departamento") %></h2>
		<%List<Empleado> emps=(List<Empleado>)request.getAttribute("empleados"); %>
		<table border="1">
			<tr><th>Nombre</th><th>Departamento</th><th>Salario</th><th>Fecha</th></tr>
			<!-- Recorro la lista de empleados y generamos una fila en la tabla por cada empleado -->
			<%for(Empleado e:emps){ %>
				<tr>
					<td><%=e.getNombre()%></td>
					<td><%=e.getDepartamento()%></td>
					<td><%=e.getSalario()%></td>
					<td><%=e.getFecha()%>
				</tr>
			<%} %>
		</table>
		<br><br>
		<a href="inicio.html">Volver</a>
	</center>
</body>
</html>
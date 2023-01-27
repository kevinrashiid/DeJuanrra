package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Empleado;
import service.EmpleadosService;


@WebServlet("/EmpleadosServlet")
public class EmpleadosServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recogemos el parametro que contiene el departamento seleccionado
		//después obtenemos la lista de empleados de ese departamento
		//lo guardamos en un atributo y transferimos el control a la JSP
		EmpleadosService service=new EmpleadosService();
		String departamento=request.getParameter("departamento");
		List<Empleado> empleados=service.empleadosDepartamento(departamento);
		request.setAttribute("empleados", empleados);
		//le mandamos también el nombre del departamento seleccionado
		request.setAttribute("departamento", departamento);
		request.getRequestDispatcher("empleados.jsp").forward(request, response);
	}

}

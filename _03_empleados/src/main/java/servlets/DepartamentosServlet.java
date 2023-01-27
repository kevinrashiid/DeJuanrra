package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EmpleadosService;


@WebServlet("/DepartamentosServlet")
public class DepartamentosServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpleadosService service=new EmpleadosService();
		List<String> depar=service.departamentos();
		request.setAttribute("departamentos", depar);
		request.getRequestDispatcher("departamentos.jsp").forward(request, response);
	}

}

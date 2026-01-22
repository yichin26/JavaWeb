package tw.tina.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet("/Course04")
public class Course04 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain; charset=UTF-8");
//		response.getWriter().append("<h1>Serve at</h1>:").append(request.getContextPath());
		
		System.out.println("Hello");
		PrintWriter out = response.getWriter();
		out.println("Hello ya");
	}

}

package tw.tina.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Course02")
public class   Course02 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		response.flushBuffer();
	}

}

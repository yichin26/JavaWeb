package tw.tina.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Course16")
public class   Course16 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		RequestDispatcher dispa = request.getRequestDispatcher("Course17");
		
		request.setAttribute("age", 18);
		request.setAttribute("x", 10);
		request.setAttribute("y", 3);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Hellooooo</h1>");
		out.println("<hr>");
		out.println("<div>oolaa</h1>");
		out.println("<hr>");
		dispa.include(request, response);
		out.println("<hr>");
		response.flushBuffer();
	}

}

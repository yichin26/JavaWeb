package tw.tina.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Course07")
public class Course07 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		try {
		int r =Integer.parseInt(x)+Integer.parseInt(y);
		System.out.printf("%s + %s= %d \n",x,y,r);
		out.printf("%s + %s = %d \n",x,y,r);		
		}catch(Exception e) {
			out.print("XXX");
		}
		
		response.flushBuffer();
	}

}

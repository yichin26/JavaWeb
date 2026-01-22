package tw.tina.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.tina.apis.Bike;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Course19")
public class   Course19 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Bike bike = (Bike)request.getAttribute("bike");
		
		PrintWriter out = response.getWriter();
		out.print("I am Course19<br>");
		out.print(bike);
		
		response.flushBuffer();
	}

}

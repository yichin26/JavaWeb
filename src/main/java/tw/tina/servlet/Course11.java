package tw.tina.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Course11")
public class Course11 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		String passwd = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		System.out.println(account + ":" + passwd+ ":" + gender);
		
		String[] hobby = request.getParameterValues("hobby");
		if(hobby !=null) {
			System.out.println(hobby.length);
			for(String h:hobby)System.out.println(h);			
		}
		System.out.println("---");
		String scale = request.getParameter("scale");
		System.out.println(scale);
		String color = request.getParameter("color"); 
		System.out.println(color);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}

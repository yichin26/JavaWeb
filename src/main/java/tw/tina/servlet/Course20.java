package tw.tina.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Course20")
public class Course20 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//HttpSession session = request.getSession(false);//沒有的話return null
		HttpSession session = request.getSession(true);//沒有的話就new一個
		
		if(session==null) {
			System.out.println("none");
		}else {
			System.out.println("else");
		}
		//request.changeSessionId();用新的id
		session.invalidate();//失效
	}

	

}

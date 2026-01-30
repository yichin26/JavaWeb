package tw.tina.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		var out = response.getWriter();
		
		String userCode = request.getParameter("code");
		
		
	    HttpSession session=request.getSession();
		String serverCode =(String) session.getAttribute("capchacode");
		
		if(serverCode!=null&& serverCode.equals(userCode) ) {
			out.println("<h1>驗證成功！歡迎登入</h1>");
			session.removeAttribute("capchacode");
		}else {
			out.println("<h1>驗證失敗！請重新登入</h1>");
			out.println("<a href='check.html'>回上一頁重試</a>");
		}
		
		
		
		
	}

}

package tw.tina.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.tina.apis.Gift;
import tw.tina.dao.GiftDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/GiftMain")
public class GiftServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. user
		request.setCharacterEncoding("UTF-8");
		int page=1;
		try {
		page = Integer.parseInt(request.getParameter("page"));
		}catch (Exception e) {
			System.out.println(e);
		}
		//2. Model
		try {
			List<Gift> gifts = new GiftDAO(page,10).findAll();
			request.setAttribute("gifts", gifts);
			request.setAttribute("prev", page-1);
			request.setAttribute("page", page);
			request.setAttribute("next", page+1);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		//3. viewer
		request.getRequestDispatcher("GiftViewer").forward(request, response);
		
	}

}

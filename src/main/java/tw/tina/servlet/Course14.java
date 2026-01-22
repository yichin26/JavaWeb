package tw.tina.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;


@WebServlet("/Course14")
public class   Course14 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		double rate =0; // 50%
		
		try {
		String r = request.getParameter("rate");
		rate = Double.parseDouble(r);
		}catch (Exception e) {
			
		}

		BufferedImage img = new BufferedImage(400, 20, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();
		
		g2d.setColor(Color.gray);
		g2d.fillRect(0, 0, 400, 20);
		g2d.setColor(Color.yellow);
		g2d.fillRect(0, 0, (int)(400*rate/100), 20);
		
		
		response.setContentType("image/jpeg");
		ImageIO.write(img, "JPEG", response.getOutputStream());
		
		response.flushBuffer();
	}

}

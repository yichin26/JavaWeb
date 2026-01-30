package tw.tina.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.imageio.ImageIO;

@WebServlet("/CAPTCHA")
public class CAPTCHA extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		Random r = new Random();
        StringBuilder sb = new StringBuilder();	
        int x=50;
        int y=60;

		for(int i=0;i<4;i++) {
			int num = r.nextInt(10);
			sb.append(num);
		}
		
		String word = sb.toString();
		
		HttpSession session=request.getSession();
		session.setAttribute("capchacode",word);
		System.out.println("code:"+word);

		BufferedImage img = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();
		
		Font f = new Font(null,Font.BOLD,40);
		AffineTransform trans = new AffineTransform();
		trans.shear(1,0);
		Font ft= f.deriveFont(trans);
		
		
		g2d.setFont(ft);				
		g2d.setColor(Color.DARK_GRAY);
		g2d.fillRect(0, 0, 400, 200);
		for(int i=0;i<15;i++) {
			g2d.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)) );
			
			int x1 = r.nextInt(200);
			int x2 = r.nextInt(200);
			int y1 = r.nextInt(100);
			int y2 = r.nextInt(100);
			g2d.drawLine(x1, y1, x2, y2);
		}
		
		for(int i=0;i<4;i++) {
			g2d.setColor(new Color(r.nextInt(150),r.nextInt(150),r.nextInt(150)) );
			String worddraw = String.valueOf(word.charAt(i));
		    g2d.drawString(worddraw, x, y);
		    x+=25;
		}
		//g2d.drawArc(0, 0, 200, 100, 0, 45);

		response.setContentType("image/jpeg");
		ImageIO.write(img, "JPEG", response.getOutputStream());
		response.flushBuffer();
	}

}

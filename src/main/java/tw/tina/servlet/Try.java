package tw.tina.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;

@WebServlet("/Try")
public class Try extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

//		double rate = 0; // 50%
		
		int num = (int)(Math.random()*10+1); 
		int pd[]=new int[4];
		for(int i=0;i<pd.length;i++) {
			num = pd[i];
		}
		System.out.println(num);
		
		String word = Integer.toString(num);

		BufferedImage img = new BufferedImage(400, 200, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = img.createGraphics();
		
		Font f = new Font(null,Font.BOLD,80);
		AffineTransform trans = new AffineTransform();
		trans.shear(1,0);
		Font ft= f.deriveFont(trans);
		g2d.setFont(ft);				
		g2d.setColor(Color.gray);
		g2d.fillRect(0, 0, 400, 200);
		g2d.setColor(Color.red);
		g2d.drawString(word, 80, 80);
		
		g2d.drawArc(0, 0, 200, 100, 0, 45);

//		g2d.setColor(Color.yellow);
//		g2d.fillRect(0, 0, (400*num/10000), 20);

		response.setContentType("image/jpeg");
		ImageIO.write(img, "JPEG", response.getOutputStream());
		response.flushBuffer();
		
//		ImageIO.write(img, "JPEG", new File(target));
	}

}

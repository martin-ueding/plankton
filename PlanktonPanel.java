import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Font;

import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.FileNotFoundException;
import java.io.IOException;

@SuppressWarnings("serial")
public class PlanktonPanel extends JPanel {
	Image imBg, imMine, imLogo, imKreis;
	Image[] p;
	ImageObserver io = this;
	ClassLoader cl;
	Font schrift = new Font("Monaco", Font.PLAIN, 14);
	
	//private static final Color dunkelblau = new Color(5, 45, 105);
	
	public PlanktonPanel () {
		cl = this.getClass().getClassLoader();
		p = new Image[3];

		try {
			imBg = javax.imageio.ImageIO.read(cl.getResource("bg.jpg"));
			imMine = javax.imageio.ImageIO.read(cl.getResource("mine.png"));
			imLogo = javax.imageio.ImageIO.read(cl.getResource("logogames.png"));
			imKreis = javax.imageio.ImageIO.read(cl.getResource("kreis.png"));
			
			for (int i = 0; i < p.length; i++)
				p[i] = javax.imageio.ImageIO.read(cl.getResource("p"+i+".png"));
				
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
	
	protected void paintComponent (Graphics g) {
		g.drawImage(imBg, 0, 0, io);
		g.drawImage(imLogo, (getWidth()-131)/2, (getHeight()-140)/2, io);
		
		g.setFont(schrift);
		
		if (Plankton.challenge)
			for (int i = 0; i < Plankton.minen.length; i++)
				g.drawImage(imMine, Plankton.minen[i].x-16, Plankton.minen[i].y-16, io);
				
		for (int i = 0; i < Plankton.plankton.length; i++)
			g.drawImage(p[i%p.length], Plankton.plankton[i].x-5, Plankton.plankton[i].y-5, io);
		
		int x, y;
		
		for (int i = 0; i < Plankton.glieder.length; i++) {
			if (Plankton.glieder[i].next != null) {
				x = (int)Plankton.glieder[i].next.x;
				y = (int)Plankton.glieder[i].next.y;
				g.drawLine(x, y, (int)Plankton.glieder[i].x, (int)Plankton.glieder[i].y);
			}
			g.drawImage(imKreis, (int)(Plankton.glieder[i].x-4), (int)(Plankton.glieder[i].y-4), io);
		}
		
		g.drawString(Spr.get("gefressen") + ": " + Plankton.gefressen, 10, 30);
	}
}

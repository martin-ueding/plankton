import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Point;

import java.util.Timer;

public class Plankton {
	public static Glied[] glieder;
	public static Point[] minen;
	public static Point[] plankton;
	
	public static JFrame frame;
	public static int gefressen = 0;
	
	public static boolean challenge;
	public static final int MINENRADIUS = 20;
	public static final int PLANKTONRADIUS = 5;
	
	public static void main (String[] args) {
		glieder = new Glied[1];
		for (int i = 0; i < glieder.length; i++) {
			glieder[i] = new Glied();
			glieder[i].x=i*10+10;
			glieder[i].y=10;
			if (i > 0) {
				glieder[i-1].next=glieder[i];
			}
		}
		
		challenge = JOptionPane.showConfirmDialog(null, Spr.get("challengetext"), Spr.get("challengetitel"), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
		
		if (challenge) {
			minen = new Point[10];
			for (int i = 0; i < minen.length; i++)
				do
					minen[i] = new Point((int)(Math.random()*600+100), (int)(Math.random()*400+100));
				while (minen[i].x > 330 && minen[i].x < 460 && minen[i].y > 210 && minen[i].y < 370);
		}
		
		plankton = new Point[20];
		for (int i = 0; i < plankton.length; i++)
			do
				plankton[i] = new Point((int)(Math.random()*600+100), (int)(Math.random()*400+100));
			while (plankton[i].x > 330 && plankton[i].x < 460 && plankton[i].y > 210 && plankton[i].y < 370);

		Timer timer = new Timer();
		timer.schedule(new Schieber(), 5000, 150);	
		
		frame = new JFrame("Plankton");
		frame.add(new PlanktonPanel());
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.addMouseMotionListener(new MyMML());
	}
	
	public static void gameover () {
		System.exit(0);
	}
}

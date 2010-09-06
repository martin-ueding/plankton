import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Point;

public class MyMML implements MouseMotionListener {
	public void mouseDragged(MouseEvent arg0) {}

	public void mouseMoved(MouseEvent arg0) {
		Plankton.glieder[0].x = arg0.getX()-5;
		Plankton.glieder[0].y = arg0.getY()-30;
		
		Glied g = Plankton.glieder[0];
		
		for (int i = 0; i < Plankton.plankton.length; i++)
			if (Math.sqrt(Math.pow(g.x - Plankton.plankton[i].x, 2) + Math.pow(g.y - Plankton.plankton[i].y, 2)) <= Plankton.PLANKTONRADIUS) {
				do
					Plankton.plankton[i] = new Point((int)(Math.random()*600+100), (int)(Math.random()*400+100));
				while (Plankton.plankton[i].x > 330 && Plankton.plankton[i].x < 460 && Plankton.plankton[i].y > 210 && Plankton.plankton[i].y < 370);
				
				Plankton.gefressen++;
				
				if (Plankton.gefressen % 3 == 0) {
					Glied[] neu = new Glied[Plankton.glieder.length+1];
					int j;
					for (j = 0; j < Plankton.glieder.length; j++) {
						neu[j] = Plankton.glieder[j];
					}
					neu[j] = new Glied();
					neu[j].x = neu[j-1].x;
					neu[j].y = neu[j-1].y;
					neu[j-1].next = neu[j];
					Plankton.glieder = neu;
				}
			}
				
		
		while (g.next != null) {
			double zulang = Math.sqrt(Math.pow(g.x - g.next.x, 2) + Math.pow(g.y - g.next.y, 2)) / 10;
			
			if (zulang != 0) {
				g.next.x = g.x + (-g.x + g.next.x) / zulang;
				g.next.y = g.y + (-g.y + g.next.y) / zulang;
			}
			
			if (Plankton.challenge)
				for (int i = 0; i < Plankton.minen.length; i++)
					if (Math.sqrt(Math.pow(g.x - Plankton.minen[i].x, 2) + Math.pow(g.y - Plankton.minen[i].y, 2)) <= Plankton.MINENRADIUS)
						Plankton.gameover();

			
			
			g = g.next;
		}
		
		Plankton.frame.repaint();
	}

}

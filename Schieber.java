import java.util.TimerTask;

public class Schieber extends TimerTask {
	public void run () {
		for (int i = 0; i < Plankton.plankton.length; i++) {
			Plankton.plankton[i].x += 2;
			if (Plankton.plankton[i].x > 700) {
				Plankton.plankton[i].x = Plankton.plankton[i].x % 700 + 100;
			}
			else if (Plankton.plankton[i].x > 330 && Plankton.plankton[i].x < 460 && Plankton.plankton[i].y > 210 && Plankton.plankton[i].y < 370) {
				Plankton.plankton[i].x += 150;
			}
		}
		
		for (int i = 0; i < Plankton.minen.length; i++) {
			Plankton.minen[i].x += 1;
			if (Plankton.minen[i].x > 700) {
				Plankton.minen[i].x = Plankton.minen[i].x % 700 + 100;
			}
			else if (Plankton.minen[i].x > 330 && Plankton.minen[i].x < 460 && Plankton.minen[i].y > 210 && Plankton.minen[i].y < 370) {
				Plankton.minen[i].x += 150;
			}
		}
		
		Plankton.frame.repaint();
	}
}

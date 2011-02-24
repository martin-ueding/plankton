/*
 * Copyright (c) 2010 Martin Ueding <dev@martin-ueding.de>
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

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

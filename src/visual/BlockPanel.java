/*
 * Java Visual Transform, demonstration application used to demonstrate an
 * introduction to image compression.
 * Copyright (C) 2012  Luke Campbell
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Limited GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Limited GNU General Public License for more details.
 * 
 * You should have received a copy of the Limited GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * See COPYING and COPYING.LESSER for more information.s
 */

package visual;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * BlockPanel
 * Represents a single block, visually differentiable based on the luminescence value provided
 * @author Luke Campbell luke.s.campbell@gmail.com
 *
 */
public class BlockPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1864042012855496240L;
	private int luma;
	/**
	 * Constructs a rectangle shaded appropriately based on the Luma value
	 * @param luma Luminescence Value, 0 - 255
	 */
	public BlockPanel(int luma) {
		if(luma>=0 && luma < 256)
			this.luma=luma;
		else
			this.luma=0;
		//0.299 R + 0.587 G + 0.114 B
		
	}
	/**
	 * Overriding paintComponent to paint the desired shaded rectangle
	 * @param g Graphics component
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(luma,luma,luma));
		g.fillRect(0,0,getWidth(),getHeight());
		String val = Integer.toString(luma);
		g.setColor(Color.cyan);
		g.drawChars(val.toCharArray(), 0, val.length(), getWidth()/4,getHeight()/2);
	}
	
}

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class BlockPanel extends JPanel {
	private int luma;
	public BlockPanel(int luma) {
		if(luma>=0 && luma < 256)
			this.luma=luma;
		else
			this.luma=0;
		//0.299 R + 0.587 G + 0.114 B
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(luma,luma,luma));
		g.fillRect(0,0,getWidth(),getHeight());
		String val = Integer.toString(luma);
		g.setColor(Color.cyan);
		g.drawChars(val.toCharArray(), 0, val.length(), getWidth()/4,getHeight()/2);
		
	}
	
}

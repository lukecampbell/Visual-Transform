import java.awt.GridLayout;

import javax.swing.JFrame;


public class MBFrame extends JFrame {
	public MBFrame() {
		setTitle("Macro Block");
		setLayout(new GridLayout(4,4));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(300,300);
		repaint();
	}
	public MBFrame(int[][] block)
	{
		this();
		buildMB(block);
	}
	public MBFrame(long[][] block)
	{
		this();
		buildMB(block);
	}
	public MBFrame(double[][] block)
	{
		this();
		buildMB(block);
	}
	public void buildMB(int[][] block)
	{
		int N = block.length;
		if(N!=block[0].length)
			throw new NumberFormatException("Matrix size is not base 2");
		setLayout(new GridLayout(N,N));
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				add(new BlockPanel(block[i][j]));
		repaint();
	}
	public void buildMB(long[][] block)
	{
		int N = block.length;
		if(N!=block[0].length)
			throw new NumberFormatException("Matrix size is not base 2");
		setLayout(new GridLayout(N,N));
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				add(new BlockPanel((int)block[i][j]));
		repaint();
	}
	public void buildMB(double[][] block)
	{
		int N = block.length;
		if(N!=block[0].length)
			throw new NumberFormatException("Matrix size is not base 2");
		setLayout(new GridLayout(N,N));
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				add(new BlockPanel((int)Math.round(block[i][j])));
		repaint();
	}
	
}

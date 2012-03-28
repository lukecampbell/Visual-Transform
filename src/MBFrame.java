import java.awt.GridLayout;

import javax.swing.JFrame;


public class MBFrame extends JFrame {
	private static final long serialVersionUID = 8394045195876396747L;
	/**
	 * Constructs a window consisting of a generic 4x4 layout
	 * @param title Desired title of the JFrame
	 */
	public MBFrame(String title) {
		setTitle(title);
		setLayout(new GridLayout(4,4));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(300,300);
		repaint();
	}
	/**
	 * Construct the window using block.
	 * @param block An NxN matrix of integer values
	 * @param title Desired title of the JFrame
	 */
	public MBFrame(int[][] block, String title)
	{
		this(title);
		buildMB(block);
	}
	/**
	 * Construct the window using block.
	 * @param block An NxN matrix of long values
	 * @param title Desired title of the JFrame
	 */
	public MBFrame(long[][] block, String title)
	{
		this(title);
		buildMB(block);
	}
	/**
	 * Construct the window using block.
	 * @param block An NxN matrix of double values
	 * @param title Desired title of the JFrame
	 */
	public MBFrame(double[][] block, String title)
	{
		this(title);
		buildMB(block);
	}
	/**
	 * Constructs the window based on the values in block
	 * @param block NxN matrix of integers
	 */
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
	/**
	 * Constructs the window based on the values in block
	 * @param block NxN matrix of longs
	 */
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
	/**
	 * Constructs the window based on the values in block
	 * @param block NxN matrix of doubles
	 */
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

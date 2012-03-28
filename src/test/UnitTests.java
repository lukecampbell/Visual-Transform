package test;

import visual.MBFrame;
import comp.DiscreteCosineTransform;
public class UnitTests {

	/**
	 * Provides an example of generating a 4x4 Macro Block displaying it visually, performing a DCT,
	 * quantizing the result then IDCT to reconstruct a very close replica of the original macro block
	 * @param args not used
	 */

    public static void main(String[] args) { 
    	testVisual(20, 1);
    	
    }
    /**
     * Performs a test of the visual capabilities as well as performing a DCT and iDCT with accuracy
     * @param quant The quantization threshold 
     * @param k The accuracy threshold such that k=0 implies perfect copy (lossless)
     * @return Returns true if the test passes
     */
    public static boolean testVisual(double quant, double k)
    {
    	double[][] X = new double[4][4]; // Standard Macroblock size in this app, 4x4
    	// Initialize the Matrix
    	for(int i=0;i<4;i++)
    		for(int j=0;j<4;j++)
    			X[i][j] = (64 * i) + (16 * j);
    	// Display the initial matrix
    	new MBFrame(X, "Original");
    	/*
    	 * ----------------------------------------------------------------------
    	 * Perform the DCT of X and then quantize Y, first round down then drop 
    	 * all values that aren't within the threshold quant
    	 * ----------------------------------------------------------------------
    	 */
    	double[][] Y = DiscreteCosineTransform.dct(X);
    	long[][] Y_prime = DiscreteCosineTransform.quantize(Y);
    	for(int i=0;i<4;i++)
    		for(int j=0;j<4;j++)
    		{
    			if(i>1 || j>1)
    				if(Math.abs(Y_prime[i][j]) < quant)
    					Y_prime[i][j] = 0;
    		}
    	// Print the Matrix to the console, the values are too extreme to be represented visually
    	DiscreteCosineTransform.printMatrix(Y_prime);
    	// Inverse DCT of the matrix
    	double[][] X_prime = DiscreteCosineTransform.idct(Y_prime);
    	new MBFrame(X_prime, "Reconstructed");
    	System.out.println("--------------------------");
    	DiscreteCosineTransform.printMatrix(Y_prime);
    	for(int i=0;i<4;i++)
    		for(int j=0;j<4;j++)
    		{
    			double delta = Math.abs(X[i][j] - X_prime[i][j]);
    			if(delta > k)
    			{
    				return false;
    			}
    		}
    	return true;
    }

}

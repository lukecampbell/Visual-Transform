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
 * See COPYING and COPYING.LESSER for more information.
 */


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
    	//testVisual(3, 1);
    	testCrafted(20, 1);
    	
    }
    public static boolean testCrafted(double quant, double k)
    {
    	double[][] X = new double[4][4];
    	for(int i=0;i<4;i++)
    		for(int j=0;j<4;j++)
    			X[i][j] = Math.random() * 256;
    	
    	new MBFrame(X,"Original");
    	
    	double[][] Xt = DiscreteCosineTransform.dct(X);
    	System.out.println("Before Quantization\n-----------------------------------");
    	DiscreteCosineTransform.printMatrix(Xt);
    	long[][] Yt = DiscreteCosineTransform.quantize(Xt);
    	for(int i=0;i<4;i++)
    		for(int j=0;j<4;j++)
    		{
    			if(i > 1 || j > 1)
	    			if(Math.abs(Yt[i][j]) < quant)
	    				Yt[i][j] = 0;
    		}
    	System.out.println("After Quantization\n-----------------------------------");
    	DiscreteCosineTransform.printMatrix(Yt);
    	double[][] Y = DiscreteCosineTransform.idct(Yt);
    	new MBFrame(Y, "Reconstructed");
    	return true;
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
    	System.out.println("After Transform\n--------------------------");
    	DiscreteCosineTransform.printMatrix(Y);
    	long[][] Y_prime = DiscreteCosineTransform.quantize(Y);
    	for(int i=0;i<4;i++)
    		for(int j=0;j<4;j++)
    		{
    			if(i>1 || j>1)
    				if(Math.abs(Y_prime[i][j]) < quant)
    					Y_prime[i][j] = 0;
    		}
    	// Print the Matrix to the console, the values are too extreme to be represented visually
    	System.out.println("After Quantization\n--------------------------");
    	DiscreteCosineTransform.printMatrix(Y_prime);
    	// Inverse DCT of the matrix
    	double[][] X_prime = DiscreteCosineTransform.idct(Y_prime);
    	new MBFrame(X_prime, "Reconstructed");
    	
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

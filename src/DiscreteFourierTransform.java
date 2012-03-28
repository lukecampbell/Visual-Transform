public class DiscreteFourierTransform {

    public static void main(String[] args) { 
    	double[][] X = new double[4][4];
    	for(int i=0;i<4;i++)
    		for(int j=0;j<4;j++)
    			X[i][j] = (64 * i) + (16 * j);
    	new MBFrame(X);
    	
    	double[][] Y = dct(X);
    	long[][] Y0 = quantize(Y);
    	for(int i=0;i<4;i++)
    		for(int j=0;j<4;j++)
    		{
    			if(i>1 || j>1)
    				if(Math.abs(Y0[i][j])<20)
    					Y0[i][j]=0;
    		}
    	printMatrix(Y0);
    	double[][] X0 = idct(Y0);
    	new MBFrame(X0);
    	printMatrix(Y0);
    	
    }
    public void zigZag() {
    	
    }
    public static double[][] idct(long[][] X){
    	
    	double[][] Y = new double[X.length][X[0].length];
    	for(int i=0;i<X.length;i++)
    		for(int j=0;j<X[0].length;j++)
    			Y[i][j]=X[i][j];
    	return idct(Y);
    }
    public static double[][] dct(long[][] X) {
    	double[][] Y = new double[X.length][X[0].length];
    	for(int i=0;i<X.length;i++)
    		for(int j=0;j<X[0].length;j++)
    			Y[i][j]=X[i][j];
    	return dct(Y);
    }
    public static long[][] quantize(double[][] X) {
    	int N = X.length;
    	long retVal[][];
    	if(X[0].length!=N)
    		throw new NumberFormatException("Matrix size is not base 2");
    	retVal = new long[N][N];
    	for(int i=0;i<N;i++)
    		for(int j=0;j<N;j++)
    			retVal[i][j] = Math.round(X[i][j]);
    	return retVal;
    }
    public static double[][] dct(double[][] X) {
    	double[][] A;
    	int N = X.length;
    	if(X[0].length!=N)
    		throw new NumberFormatException("Matrix size is not base 2");
    	A = new double[N][N];
    	for(int i=0;i<N;i++)
    	{
    		for(int j=0;j<N;j++)
    		{
	    		double C;
				if(i==0)
					C = Math.sqrt(1.0/(N*1.0));
				else
					C = Math.sqrt(2.0/(N*1.0));
				A[i][j] = C * Math.cos(((2.0 * j + 1.0) * i * Math.PI)/(8.0));
//				System.out.print(A[i][j]+" ");
    		}
//    		System.out.println();
    	}
    	double[][] Y = new double[N][N];
    	for(int x=0;x<N;x++)
    		for(int y=0;y<N;y++)
    			for(int i=0;i<N;i++)
    				for(int j=0;j<N;j++)
    						Y[x][y] += A[y][j] * X[i][j] * A[x][i];
    	
    	
    	return Y;
    			
    }
    
    public static double[][] idct(double[][] Y)
    {
    	double[][] A;
    	int N = Y.length;
    	if(Y[0].length!=N)
    		throw new NumberFormatException("Matrix size is not base 2");
    	A = new double[N][N];
    	for(int i=0;i<N;i++)
    	{
    		for(int j=0;j<N;j++)
    		{
	    		double C;
				if(i==0)
					C = Math.sqrt(1.0/(N*1.0));
				else
					C = Math.sqrt(2.0/(N*1.0));
				A[i][j] = C * Math.cos(((2.0 * j + 1.0) * i * Math.PI)/(8.0));
//				System.out.print(A[i][j]+" ");
    		}
//    		System.out.println();
    	}
    	double[][] X = new double[N][N];
    	for(int x=0;x<N;x++)
    		for(int y=0;y<N;y++)
    			for(int i=0;i<N;i++)
    				for(int j=0;j<N;j++)
    					X[x][y]+= A[j][y] * Y[i][j] * A[i][x];
    		
    	return X;
    }
    public static void printMatrix(double[][] matrix)
    {
    	int N = matrix.length;
    	if(N<0)
    		return;
    	int M = matrix[0].length;
    	for(int i=0;i<N;i++)
    	{
    		for(int j=0;j<M;j++)
    			System.out.print(matrix[i][j]+" ");
    		System.out.println();
    	}
    }
    public static void printMatrix(long[][] matrix)
    {
    	int N = matrix.length;
    	if(N<0)
    		return;
    	int M = matrix[0].length;
    	for(int i=0;i<N;i++)
    	{
    		for(int j=0;j<M;j++)
    			System.out.print(matrix[i][j]+" ");
    		System.out.println();
    	}
    	
    }

}


//Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
//Last updated: Wed Feb 9 09:20:16 EST 2011.
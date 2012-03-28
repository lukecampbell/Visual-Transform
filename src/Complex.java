
public class Complex {
	private double r;
	private double i;
	public Complex(double r, double i) {
		this.r = r;
		this.i = i;
	}
	public double real() {
		return r;
	}
	public double imag() {
		return i;
	}
	public double abs() {
		return Math.sqrt((r*r) + (i*i));
	}
	public Complex add(Complex c) {
		Complex retVal = new Complex(
				this.r + c.r,
				this.i + c.i);
		return retVal;
	}
	public Complex sub(Complex c) {
		Complex retVal = new Complex(
				this.r - c.r,
				this.i - c.i);
		return retVal;
	}
	public Complex mult(Complex c) {
		
		Complex retVal = new Complex(
				(this.r * c.r) - (this.i * c.i),
				(this.i * c.r) + (this.r * c.i));
		return retVal;
	}
	public Complex conjugate() {
		Complex retVal = new Complex(
				this.r, -this.i);
		return retVal;
	}
	public String toString() {
		return (r)+" + "+(i)+"i";
	}
	
}

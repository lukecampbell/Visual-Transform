/**
 * Class to represent Complex Numbers
 * @author Luke Campbell <luke.s.campbell@gmail.com>
 *
 */
public class Complex {
	/**
	 * Real component
	 */
	private double r;
	/**
	 * Imaginary or Complex Component
	 */
	private double i;
	/**
	 * Build a complex number using the real and imaginary components
	 * @param r Real Component
	 * @param i Imaginary Component
	 */
	public Complex(double r, double i) {
		this.r = r;
		this.i = i;
	}
	/**
	 * Get the real component
	 * @return Real component of this complex number
	 */
	public double real() {
		return r;
	}
	/**
	 * Get the imaginary component
	 * @return Imaginary component of this complex number
	 */
	public double imag() {
		return i;
	}
	/**
	 * Absolute value
	 * @return Absolute value of this complex number.
	 */
	public double abs() {
		return Math.sqrt((r*r) + (i*i));
	}
	/**
	 * Complex addition
	 * @param c A complex number to be added to this
	 * @return The sumamtion of this and c
	 */
	public Complex add(Complex c) {
		Complex retVal = new Complex(
				this.r + c.r,
				this.i + c.i);
		return retVal;
	}
	/**
	 * Subtraction of c from this
	 * @param c Complex Number to be subtracted
	 * @return The subtraction of c from this
	 */
	public Complex sub(Complex c) {
		Complex retVal = new Complex(
				this.r - c.r,
				this.i - c.i);
		return retVal;
	}
	/**
	 * Multiplication
	 * @param c Complex Number
	 * @return The product of this and c
	 */
	public Complex mult(Complex c) {
		
		Complex retVal = new Complex(
				(this.r * c.r) - (this.i * c.i),
				(this.i * c.r) + (this.r * c.i));
		return retVal;
	}
	/**
	 * Complex Conjugate
	 * @return The conplex conjugate of this
	 */
	public Complex conjugate() {
		Complex retVal = new Complex(
				this.r, -this.i);
		return retVal;
	}
	/**
	 * String representation of this numbers
	 */
	public String toString() {
		return (r)+" + "+(i)+"i";
	}
	
}

//Amanda Ortiz 
//Spring 2015 - Algorithms - Kart
//Rational Numbers

package rationalnumbers;



public class RationalNumberImpl_Ortiz implements RationalNumber
{
	private int num;
	private int den;
	
	//creating the rational number
	public RationalNumberImpl_Ortiz(int numerator, int denominator)
	{
		if (denominator == 0)
		{
			System.out.println("Denominator is a zero!\n Cannot proceed");
			System.exit(0);
			
		}
		
		//reducing the fraction
		int reduced = greatestCommonFactor(numerator, denominator);
		num = numerator / reduced;
		den = denominator / reduced;
		
		//if there's a negative..
		if(den < 0) 
		{
			den = -den; 
			num = -num;
		}
		
		
	}
	
	//gets numerator
	public int getNumerator() 
	{
		return num;
	}

	
	//gets denominator
	public int getDenominator() 
	{
		return den;
	}

	//returns the double equivalent of rational number
	public double getValue() 
	{
		double rv = num / den;
		return rv;
	}
	
	//returns the greatest common factor
	//greatestCommonFactor(2, 7) = 1
	//greatestCommonFactor(3, -9) = ???
	public static int greatestCommonFactor(int a, int b)
	{
		a = Math.abs(a);
		b = Math.abs(b);
		
		if (b == 0)
		{
			return a;
		}
		
		return greatestCommonFactor(b, a % b);
	
	}
	
	//toString calls .toString from Utils 
	public String toString()
	{
		return RationalNumberUtils_Ortiz.toString(this);
	}
	

	
	public static void main(String[] args)
	{

		RationalNumber rv;
		RationalNumber rv2;
		boolean equals;
		
		//test numbers
		RationalNumber r1 = new RationalNumberImpl_Ortiz (1,-2);
		RationalNumber r2 = new RationalNumberImpl_Ortiz (1,2);
		
		
		System.out.println("Your testing numbers: " + r1 + " and " + r2 + ".\n");
		
		equals = RationalNumberUtils_Ortiz.equal(r1, r2);
		System.out.println("Numbers equal?: " + equals);
		
		rv = RationalNumberUtils_Ortiz.add(r1, r2);
		System.out.println("Numbers Added: " + rv);
		
		rv = RationalNumberUtils_Ortiz.subtract(r1, r2);
		System.out.println("Numbers Subtracted: " + rv);
		
		rv = RationalNumberUtils_Ortiz.multiply(r1, r2);
		System.out.println("Numbers Multiplied: " + rv);
		
		rv = RationalNumberUtils_Ortiz.divide(r1, r2);
		System.out.println("Numbers Divided: " + rv);
		
		rv = RationalNumberUtils_Ortiz.negate(r1);
		rv2 = RationalNumberUtils_Ortiz.negate(r2);
		System.out.println("Numbers Negated: " + rv + ", " + rv2);
		
		
		
	}

}

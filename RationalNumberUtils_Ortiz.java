//Amanda Ortiz 
//Spring 2015 - Algorithms - Kart
//Rational Numbers
package rationalnumbers;

public class RationalNumberUtils_Ortiz 
{
	
	
	//rv is true <==> r1 = r2 as rational numbers
	public static boolean equal(RationalNumber r1, RationalNumber r2)
	{
		if(r1.getNumerator() == r2.getNumerator() && r1.getDenominator() == r2.getDenominator())
		{
				return true;
		}
		
		return false;
		
	}
	//rv = r1 + r2, where + is regular numerical additon
	public static RationalNumber add(RationalNumber r1, RationalNumber r2)
	{
		//find greatest common denominator
		int numerators = RationalNumberImpl_Ortiz.greatestCommonFactor(r1.getNumerator(),r2.getNumerator());
		int denominators = RationalNumberImpl_Ortiz.greatestCommonFactor(r1.getDenominator(),r2.getDenominator());
		
		RationalNumber ratNum = new RationalNumberImpl_Ortiz((r1.getNumerator() / numerators) * (r2.getDenominator() / denominators) + 
				(r2.getNumerator() / numerators) * (r1.getDenominator() / denominators), r2.getDenominator() );
		RationalNumber ratNum2 = new RationalNumberImpl_Ortiz(ratNum.getNumerator() * numerators,ratNum.getDenominator());
		
		
		return ratNum2;
		 
		
		
	}
		
	//rv = r1 + r2, where + is regular numerical subtraction
	public static RationalNumber subtract(RationalNumber r1, RationalNumber r2)
	{
		RationalNumber ratNum = add(r1, negate(r2));
		
		return ratNum;
		
	}
	//to convert to a String so user can see results
	public static String toString(RationalNumber ratNum) 
	{ 
        if (ratNum.getDenominator() == 1) 
        {
        	return ratNum.getNumerator() + "";
        }
        else          
        {
        	return ratNum.getNumerator() + "/" + ratNum.getDenominator();
        }
	}
	//rv = r1 + r2, where + is regular numerical multiplication
	public static RationalNumber multiply(RationalNumber r1, RationalNumber r2)
	{
		RationalNumber ratNum1 = new RationalNumberImpl_Ortiz(r1.getNumerator(),r2.getDenominator());
		RationalNumber ratNum2 = new RationalNumberImpl_Ortiz(r2.getNumerator(), r1.getDenominator());
		
		RationalNumber ratNum3 = new RationalNumberImpl_Ortiz(ratNum1.getNumerator() * ratNum2.getNumerator(), ratNum1.getDenominator() * ratNum2.getDenominator());
		return ratNum3;
		
	}
		
	//rv = r1 + r2, where + is regular numerical division
	public static RationalNumber divide(RationalNumber r1, RationalNumber r2)
	{
		RationalNumber ratNum = multiply(r1, reciprocal(r2));
		return ratNum;
		
	}
	
	//Reciprocal flips the number
	//ex: 1/2 = 2/1
	public static RationalNumber reciprocal(RationalNumber r1)
	{
		return new RationalNumberImpl_Ortiz(r1.getDenominator(), r1.getNumerator());
	}
			
	//rv = r1 + r2, where + is regular numerical negation
	public static RationalNumber negate(RationalNumber r1)
	{
		
		RationalNumber ratNum = new RationalNumberImpl_Ortiz(-r1.getNumerator(), r1.getDenominator());
		return ratNum;
		
	}
}

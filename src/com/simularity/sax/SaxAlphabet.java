// SaxAlphabet - Abstraction of the SAX Alphabet concept
// Supports SaxAlphabets from 2 .. 16 letters

package com.simularity.sax;

public class SaxAlphabet {
	public enum Alphabet {SAX_2, SAX_3, SAX_4, SAX_5, SAX_6, SAX_7, SAX_8, SAX_9,
				SAX_10, SAX_11, SAX_12, SAX_13, SAX_14, SAX_15, SAX_16};

	// The cuts are the limits of each SAX letter for a given alphabet
	protected static double[][] cuts = {
		{0},
		{-0.430727,0.430727},
		{-0.67449,0,0.67449},
		{-0.841621,-0.253347,0.253347,0.841621},
		{-0.967422,-0.430727,0,0.430727,0.967422},
		{-1.06757,-0.565949,-0.180012,0.180012,0.565949,1.06757},
		{-1.15035,-0.67449,-0.318639,0,0.318639,0.67449,1.15035},
		{-1.22064,-0.76471,-0.430727,-0.13971,0.13971,0.430727,0.76471,1.22064},
		{-1.28155,-0.841621,-0.524401,-0.253347,0,0.253347,0.524401,0.841621,1.28155},
		{-1.33518,-0.908458,-0.604585,-0.348756,-0.114185,0.114185,0.348756,0.604585,
		 0.908458,1.33518},
		{-1.38299,-0.967422,-0.67449,-0.430727,-0.210428,-1.39146e-16,0.210428,0.430727,
		 0.67449,0.967422,1.38299},
		{-1.42608,-1.02008,-0.736316,-0.502402,-0.293381,-0.0965586,0.0965586,0.293381,
		 0.502402,0.736316,1.02008,1.42608},
		{-1.46523,-1.06757,-0.791639,-0.565949,-0.366106,-0.180012,-2.78292e-16,0.180012,
		 0.366106,0.565949,0.791639,1.06757,1.46523},
		{-1.50109,-1.11077,-0.841621,-0.622926,-0.430727,-0.253347,-0.0836517,0.0836517,
		 0.253347,0.430727,0.622926,0.841621,1.11077,1.50109},
		{-1.53412,-1.15035,-0.887147,-0.67449,-0.488776,-0.318639,-0.157311,0,0.157311,
		 0.318639,0.488776,0.67449,0.887147,1.15035,1.53412}
	};

	public static byte getSaxLetter(Alphabet alpha, double value) {
		// Remember that alpha is offset by 3 from the actual amount of letters
		// And that the number of cuts is NumberOfLetters - 1
		for (byte i = 0; i < (byte) alpha.ordinal() + 1; i++) {
			if (value < cuts[alpha.ordinal()][i]) {
				return i;
			}
		}
		// Max is 1 less than the number of letters (0 is a letter)
		return (byte) (alpha.ordinal() + 1);
	};
	public static int space(Alphabet alpha) {
		return alpha.ordinal() + 2;
	};
};
		
	
	

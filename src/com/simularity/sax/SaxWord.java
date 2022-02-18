
package com.simularity.sax;

import java.math.BigInteger;

import com.simularity.sax.PAA;
import com.simularity.sax.Deviator;
import com.simularity.sax.SaxAlphabet;

public class SaxWord {
	protected SaxAlphabet.Alphabet alpha;
	protected short[] word;

	/**
	 * Create a SaxWord which is normalized as a time series
	 *
	 * @param a The Alphabet to use
	 * @param paa The PAA to Normalize to a SAX Word
	 * @param dev The Deviator to use to normalize the SAX word with itself
	 */
	
	public SaxWord(SaxAlphabet.Alphabet a, PAA paa, Deviator dev) {
		int len = paa.getLength();
		word = new short[len];
		alpha = a;
		for (int i = 0; i < word.length; i++) {
			word[i] = SaxAlphabet.getSaxLetter(a, dev.normalize(paa.getIndex(i)));
		}
	};

	/**
	 * Create a SaxWord where each element is normalized from a different Deviator.
	 * This allows us to construct SaxWords from data that are NOT time series, but rather discrete co-temporal values
	 *
	 * @param a The SAX Alphabet
	 * @param paa The PAA to convert to a SAX Word
	 * @param dev An array of deviators to convert paa. Must be the same size a PAA
	 *
	 */
	
	public SaxWord(SaxAlphabet.Alphabet a, PAA paa, Deviator [] dev) throws IllegalArgumentException {
		int len = paa.getLength();
		if (len != dev.length) {
			throw new IllegalArgumentException("SAX: Deviator Array not the same size as PAA");
		}
				
		word = new short[len];
		alpha = a;
		for (int i = 0; i < word.length; i++) {
			word[i] = SaxAlphabet.getSaxLetter(a, dev[i].normalize(paa.getIndex(i)));
		}
	}

	public SaxWord(SaxAlphabet.Alphabet a, int len, BigInteger saxInt) throws IllegalArgumentException {
		if (len < 0) {
			throw new IllegalArgumentException("SAX length must be positive");
		}
		alpha = a;
		BigInteger space = BigInteger.valueOf(SaxAlphabet.space(alpha));
		word = new short[len];
		int i;
		for (i = 0; i < len; i++) {
			BigInteger [] res = saxInt.divideAndRemainder(space);
			word[i] = res[1].shortValueExact();
			saxInt = res[0];
		}
	};
		      

	public BigInteger getSaxInt() {
		BigInteger place = BigInteger.valueOf(1);
		BigInteger value = BigInteger.valueOf(0);
		BigInteger space = BigInteger.valueOf(SaxAlphabet.space(alpha));
		for (int i = 0; i < word.length; i++) {
			value = value.add(place.multiply( BigInteger.valueOf(word[i])));
			place = place.multiply(space);
		}
		return value;
	};

	public short [] getSaxBytes() {return word.clone();};
	public char [] getSaxChars() {
		char [] result = new char[word.length];
		for (int i = 0; i < word.length; i++) {
			result[i] = (char) ('a' + word[i]);
		}

		return result;
	};
	public int getLength() {return word.length;};
};

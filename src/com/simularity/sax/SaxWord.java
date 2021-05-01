
package com.simularity.sax;

import com.simularity.sax.PAA;
import com.simularity.sax.Deviator;
import com.simularity.sax.SaxAlphabet;

public class SaxWord {
	protected SaxAlphabet.Alphabet alpha;
	protected byte[] word;

	/**
	 * Create a SaxWord which is normalized as a time series
	 *
	 * @param a The Alphabet to use
	 * @param paa The PAA to Normalize to a SAX Word
	 * @param dev The Deviator to use to normalize the SAX word with itself
	 */
	
	public SaxWord(SaxAlphabet.Alphabet a, PAA paa, Deviator dev) {
		int len = paa.getLength();
		if (len > 15) {
			throw new IllegalArgumentException("SAX length limited to 15");
		}
		word = new byte[len];
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
		if (len > 15) {
			throw new IllegalArgumentException("SAX length limited to 15");
		}
		if (len != dev.length) {
			throw new IllegalArgumentException("SAX: Deviator Array not the same size as PAA");
		}
				
		word = new byte[len];
		alpha = a;
		for (int i = 0; i < word.length; i++) {
			word[i] = SaxAlphabet.getSaxLetter(a, dev[i].normalize(paa.getIndex(i)));
		}
	}

	public SaxWord(SaxAlphabet.Alphabet a, int len, long saxInt) throws IllegalArgumentException {
		if ((len > 15) || (len < 0)) {
			throw new IllegalArgumentException("SAX length limited to 15");
		}
		alpha = a;
		int space = SaxAlphabet.space(alpha);
		word = new byte[len];
		int i;
		for (i = 0; i < len; i++) {
			word[i] = (byte) (saxInt % space);
			saxInt /= space;
		}
	};
		      

	public long getSaxInt() {
		long place = 1;
		long value = 0L;
		for (int i = 0; i < word.length; i++) {
			value += place * (int) word[i];
			place = place * SaxAlphabet.space(alpha);
		}
		return value;
	};

	public byte [] getSaxBytes() {return word.clone();};
	public char [] getSaxChars() {
		char [] result = new char[word.length];
		for (int i = 0; i < word.length; i++) {
			result[i] = (char) ('a' + word[i]);
		}

		return result;
	};
	public int getLength() {return word.length;};
};

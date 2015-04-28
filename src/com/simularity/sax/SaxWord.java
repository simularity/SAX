
package com.simularity.sax;

import com.simularity.sax.PAA;
import com.simularity.sax.Deviator;
import com.simularity.sax.SaxAlphabet;

class SaxWord {
	protected SaxAlphabet.Alphabet alpha;
	protected byte[] word;

	public SaxWord(SaxAlphabet.Alphabet a, PAA paa, Deviator dev) throws IndexOutOfBoundsException {
		int len = paa.getLength();
		if (len > 15) {
			throw new IndexOutOfBoundsException("SAX length limited to 15");
		}
		word = new byte[len];
		alpha = a;
		for (int i = 0; i < word.length; i++) {
			word[i] = SaxAlphabet.getSaxLetter(a, dev.normalize(paa.getIndex(i)));
		}
	};

	public SaxWord(SaxAlphabet.Alphabet a, int len, long saxInt) throws IndexOutOfBoundsException {
		if ((len > 15) || (len < 0)) {
			throw new IndexOutOfBoundsException("SAX length limited to 15");
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

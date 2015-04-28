
package com.simularity.sax;

import com.simularity.sax.SaxFactory;
import com.simularity.sax.SaxWord;
import com.simularity.sax.SaxAlphabet;

class Test {
	public static void main(String [] args) {
		double [] base = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0, 13.0,
				  14.0, 15.0, 16.0};
		SaxFactory factory = new SaxFactory(SaxAlphabet.Alphabet.SAX_16, 15);

		SaxWord word = factory.getWord(base);
		String str = new String(word.getSaxChars());
		System.out.printf("%s %d\n", str, word.getSaxInt());

		SaxWord word2 = new SaxWord(SaxAlphabet.Alphabet.SAX_16, 15, word.getSaxInt());
		String str2 = new String(word2.getSaxChars());
		System.out.printf("%s %d\n", str2, word2.getSaxInt());
	};
};

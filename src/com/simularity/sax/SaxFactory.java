
package com.simularity.sax;

import com.simularity.sax.SaxWord;
import com.simularity.sax.Deviator;
import com.simularity.sax.BasicDeviator;
import com.simularity.sax.SaxAlphabet;
import com.simularity.sax.SaxWord;
import com.simularity.sax.PAA;
import java.util.Map;


class SaxFactory {

	protected Deviator dev;
	protected final int length;
	protected final SaxAlphabet.Alphabet alpha;
	protected PAA paa;

	public SaxFactory(SaxAlphabet.Alphabet a, int len) {
		dev = new BasicDeviator();
		length = len;
		alpha = a;
		paa = new PAA(len);
	};

	public SaxWord getWord(double [] series) {
		dev.reset();
		for (double d : series) {
			dev.apply(d);
		}

		paa.apply(series);

		return new SaxWord(alpha, paa, dev);
	};

	public SaxWord getWord(double lo, double hi, Map<Double, Double> series) {
		dev.reset();
		for (Double d : series.values()) {
			dev.apply(d.doubleValue());
		}

		paa.apply(lo, hi, series);
		return new SaxWord(alpha, paa, dev);
	};
};
		

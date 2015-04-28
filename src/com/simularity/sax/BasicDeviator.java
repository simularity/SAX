// BasicDeviator - Accumulate Mean and StdDeviation

package com.simularity.sax;
import com.simularity.sax.Deviator;
class BasicDeviator implements Deviator {

	protected double mean;
	protected double M2;
	protected long n;
	
	public BasicDeviator() {
		mean = 0.0;
		M2 = 0.0;
		n = 0;
	};

	public void apply(double x) {
		double delta;
		n++;
		delta = x - mean;
		mean = mean + (delta / n);
		M2 = M2 + delta * (x-mean);
	};

	public void reset() {
		mean = 0.0;
		M2 = 0.0;
		n = 0;
	};
			
	public double getMean() {
		return mean;
	};

	public double getStdDev() {
		if (n < 2) {
			return 0.0;
		}
		return Math.sqrt(M2 / (n - 1));
	};

	public double normalize(double d) {
		double dev = getStdDev();
		// Perhaps we should throw an exception here?
		if (dev == 0.0) {
			return getMean();
		}

		return (d - getMean()) / dev;
	};
		
};


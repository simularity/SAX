

package com.simularity.sax;

import java.util.Map;

public class PAA {
	protected double[] vector;
	protected int [] counts;

	public PAA(int len) {
		vector = new double[len];
		counts = new int[len];
	};
	
	public void apply(double [] timeSeries) {
		int len = vector.length;

		for (int i = 0; i < len; i++) {
			vector[i] = 0.0;
			counts[i] = 0;
		}
		double boxconv = (double) len / (double) timeSeries.length;
		for (int i = 0; i < timeSeries.length; i++) {
			int box = (int) Math.floor(boxconv * (double) i);
			vector[box] += timeSeries[i];
			counts[box]++;
		}

		for (int i = 0; i < len; i++) {
			vector[i] /= counts[i];
		}
	};

	public void apply(double lo, double hi, Map<Double, Double> timeSeries) {
		int len = vector.length;

		for (int i = 0; i < len; i++) {
			vector[i] = 0.0;
			counts[i] = 0;
		}
		double delta = hi - lo;
		double conv = (double) len / delta;

		for (Map.Entry<Double, Double> e : timeSeries.entrySet()) {
			double k = e.getKey().doubleValue();
			double v = e.getValue().doubleValue();
			// if this reading is in our window
			if ((k >= lo) && (k <= hi)) {
				int box = (int) Math.floor(conv * k);
				// Handle the edge condition
				if (box >= len) {
					box = len - 1;
				}
				vector[box] += v;
				counts[box] ++;
			}
		}

		for (int i = 0; i < len; i++) {
			vector[i] /= counts[i];
		}
	};

	double [] getVector() {return vector.clone();};
	int getLength() {return vector.length;};
	double getIndex(int i) {return vector[i];};
	
};

// BinarySearch.java - Do a binary search that returns the index of the smallest item which is equal to or greater than a double

package com.simularity.sax;

public class BinarySearch {
     
	public static int findIndex(double array[], double target)
	{
		int lo = 0;
		int hi = array.length - 1;
			if (target < array[0]) {
				return 0;
			}
			else if (target > array[hi]) {
				return hi + 1;
			}
			else {
				return findIndex(lo, hi, array, target);
			}
	};
	
	protected static int findIndex(int lo, int hi, double [] array, double target) {
		if (hi == lo) {
			return lo;
		}
		int mid = ((hi - lo) / 2) + lo;

	       

		if (target == array[mid]) {
			return mid;
		}
		else if (target < array[mid]) {
			return findIndex(lo, mid, array, target);
		}
		else {
			return findIndex(mid + 1, hi, array, target);
		}
	};
};


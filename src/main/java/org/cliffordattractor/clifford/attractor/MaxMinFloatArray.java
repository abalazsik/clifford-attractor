
package org.cliffordattractor.clifford.attractor;

/**
 *
 * @author ador
 */
public class MaxMinFloatArray {

	private float min = Float.MAX_VALUE;
	private float max = Float.MIN_VALUE;
	private float[] values;

	public MaxMinFloatArray(int size) {
		values = new float[size];
	}
	
	public void add(int idx, float value) {
		values[idx] = value;
		
		if (value < min) {
			min = value;
		}
		
		if (value > max) {
			max = value;
		}
	}
	
	public float getMin() {
		return min;
	}

	public float getMax() {
		return max;
	}

	public float[] getValues() {
		return values;
	}
	
}

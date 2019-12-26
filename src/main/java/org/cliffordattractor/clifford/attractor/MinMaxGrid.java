package org.cliffordattractor.clifford.attractor;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author ador
 */
public class MinMaxGrid {

	private int maxX = Integer.MIN_VALUE;
	private int maxY = Integer.MIN_VALUE;
	private int minX = Integer.MAX_VALUE;
	private int minY = Integer.MAX_VALUE;
	private int maxIntensity = 1;
	private Map<Position, Integer> map = new TreeMap<>();
	
	public void add(int x, int y) {
		Position position = new Position(x, y);
		
		if (map.containsKey(position)) {
			int intensity = map.get(position) + 1;
			map.put(position, intensity);
			
			if (intensity > maxIntensity) {
				maxIntensity = intensity;
			}
		} else {
			map.put(position, 1);
		}
		
		if (x < minX) {
			minX = x;
		}
		if (y < minY) {
			minY = y;
		}
		if (x > maxX) {
			maxX = x;
		}
		if (y > maxY) {
			maxY = y;
		}
	}

	public int getMaxIntensity() {
		return maxIntensity;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public int getMinX() {
		return minX;
	}

	public int getMinY() {
		return minY;
	}

	public void clear() {
		map.clear();
		maxIntensity = 1;
	}
	
	public Map<Position, Integer> getMap() {
		return map;
	}

	@Override
	public String toString() {
		return "MinMaxGrid{" + "maxX=" + maxX + ", maxY=" + maxY + ", minX=" + minX + ", minY=" + minY + ", maxIntensity=" + maxIntensity + '}';
	}
	
	public static class Position implements Comparable<Position>{
		private final int x;
		private final int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		@Override
		public int hashCode() {
			int hash = 7;
			hash = 59 * hash + this.x;
			hash = 59 * hash + this.y;
			return hash;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			final Position other = (Position) obj;
			if (this.x != other.x) {
				return false;
			}
			if (this.y != other.y) {
				return false;
			}
			return true;
		}

		@Override
		public int compareTo(Position o) {
			int k = o.getX() - x;
			if (k == 0) {
				return o.getY() - y;
			}
			return k;
		}
		
	}
	
}

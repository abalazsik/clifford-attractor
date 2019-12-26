
package org.cliffordattractor.clifford.attractor;

import java.awt.Color;
import java.util.Map;

/**
 *
 * @author ador
 */
public class ParamUtil {
	
	public static Map convertInt(Map<String, Object> map, String key, String value) {
		try {
			if (value != null) {
				map.put(key, Integer.valueOf(value));
			}
		} catch(Exception e) {
			//no time to dealing with input errors, we're having fun
		}
		
		return map;
	}
	
	public static Map convertDouble(Map<String, Object> map, String key, String value) {
		try {
			if (value != null) {
				map.put(key, Double.valueOf(value));
			}
		} catch(Exception e) {
			//no time to dealing with input errors, we're having fun
		}
		
		return map;
	}
	
	public static Map convertColor(Map<String, Object> map, String key, String value) {
		try {
			if (value != null) {
				map.put(key, Color.getColor(value));
			}
		} catch(Exception e) {
			//no time to dealing with input errors, we're having fun
		}
		
		return map;
	}
	
}

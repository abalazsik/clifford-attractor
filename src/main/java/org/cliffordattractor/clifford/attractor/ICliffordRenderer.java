
package org.cliffordattractor.clifford.attractor;

import java.awt.image.BufferedImage;
import java.util.Map;

/**
 *
 * @author ador
 */
public interface ICliffordRenderer {

	public static final String PARAM_ITERATION = "iterations";
	public static final String PARAM_WIDTH = "width";
	public static final String PARAM_HEIGHT = "height";
	public static final String PARAM_A = "a";
	public static final String PARAM_B = "b";
	public static final String PARAM_C = "c";
	public static final String PARAM_D = "d";
	public static final String PARAM_SCALE = "scale";
	public static final String PARAM_BGCOLOR = "bgcolor";
	public static final String PARAM_COLOR_FROM = "color_from";
	public static final String PARAM_COLOR_TO = "color_to";
	
	BufferedImage render(Map<String, Object> props);
	
}

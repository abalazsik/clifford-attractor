
package org.cliffordattractor.clifford.attractor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author ador
 */
public class BonusCliffordRenderer implements ICliffordRenderer {
	
	private BufferedImage buffered;
	private static final int DEF_ITERATIONS = 30_000;
	private static final int DEF_WIDTH = 1600;
	private static final int DEF_HEIGHT = 900;
	private Random random = new Random();
	
	@Override
	public BufferedImage render(Map<String, Object> props) {
		
		int iteration = (int)props.getOrDefault(ICliffordRenderer.PARAM_ITERATION, DEF_ITERATIONS);
		int width = (int)props.getOrDefault(ICliffordRenderer.PARAM_WIDTH, DEF_WIDTH);
		int height = (int)props.getOrDefault(ICliffordRenderer.PARAM_HEIGHT, DEF_HEIGHT);
		double scale = (double)props.getOrDefault(ICliffordRenderer.PARAM_SCALE, 5.0);
		double a = (double)props.getOrDefault(ICliffordRenderer.PARAM_A, random.nextDouble() * scale -scale/2);
		double b = (double)props.getOrDefault(ICliffordRenderer.PARAM_A, random.nextDouble() * scale -scale/2);
		double c = (double)props.getOrDefault(ICliffordRenderer.PARAM_A, random.nextDouble() * scale -scale/2);
		double d = (double)props.getOrDefault(ICliffordRenderer.PARAM_A, random.nextDouble() * scale -scale/2);
		Color background = (Color)props.getOrDefault(ICliffordRenderer.PARAM_BGCOLOR, Color.black);
		Color fromColor = (Color)props.getOrDefault(ICliffordRenderer.PARAM_COLOR_FROM, Color.RED);
		Color toColor = (Color)props.getOrDefault(ICliffordRenderer.PARAM_COLOR_TO, Color.GREEN);
		
		
		buffered = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		
		MaxMinFloatArray xs = new MaxMinFloatArray(iteration);
		MaxMinFloatArray ys = new MaxMinFloatArray(iteration);
		
		double x = 0f;
		double y = 0f;
		
		Graphics2D g = buffered.createGraphics();
		//g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.setColor(background);
		g.fillRect(0, 0, width, height);
		
		float fromR = (float)fromColor.getRed() / 255;
		float fromG = (float)fromColor.getGreen() / 255;
		float fromB = (float)fromColor.getBlue() / 255;
		
		float toR = (float)toColor.getRed() / 255;
		float toG = (float)toColor.getGreen() / 255;
		float toB = (float)toColor.getBlue() / 255;
		
		for (int i = 0; i < iteration; i++) {
			x = Math.sin(a * y) + c * Math.cos(a * x);
			y = Math.sin(b * x) + d * Math.cos(b * y);
			
			xs.add(i, (float)x);
			ys.add(i, (float)y);
		}
		
		float xdiff = xs.getMax() - xs.getMin();
		float ydiff = ys.getMax() - ys.getMin();
		
		float[] xbuffer = xs.getValues();
		float[] ybuffer = ys.getValues();
		
		for (int i = 0; i < iteration; i++) {
			float lx = (xbuffer[i] - xs.getMin()) * (width / xdiff);
			float ly = (ybuffer[i] - ys.getMin()) * (height / ydiff);
			
			if (lx > 0 && ly > 0 && lx < width && ly < height) {
				
				float _r =  (toR - fromR) / iteration * i + fromR;
				float _g =  (toG - fromG) / iteration * i + fromG;
				float _b =  (toB - fromB) / iteration * i + fromB;
				
				Color color = new Color(_r, _g, _b);
				
				buffered.setRGB(
						((int)lx),
						((int)ly),
						color.getRGB());
			}
		}
		
		//g.setColor(Color.BLUE);
		//g.drawString(String.format("a: %f, b: %f, c: %f, d: %f", a, b, c, d), 10, 10);
		
		return buffered;
	}

}
